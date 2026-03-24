#!/usr/bin/env node
/**
 * 프로그래머스 문제 추천 스크립트 (HTTP only, Puppeteer 불필요)
 * Usage: node get_problems.js <level>
 * Output: JSON { title, url, id, packageName, level, description, javaMethod }
 */

const https = require('https');
const path = require('path');
const fs = require('fs');

const level = parseInt(process.argv[2]);
if (!level || level < 1 || level > 5) {
  process.stderr.write('Usage: node get_problems.js <level (1~5)>\n');
  process.exit(1);
}

const SRC_PATH = path.join(__dirname, '..', 'src');
const BASE_HEADERS = {
  'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36',
  'Accept': 'application/json',
  'Referer': 'https://school.programmers.co.kr/learn/challenges'
};

function get(url, headers = BASE_HEADERS) {
  return new Promise((resolve, reject) => {
    https.get(url, { headers }, res => {
      let data = '';
      res.on('data', chunk => data += chunk);
      res.on('end', () => resolve({ status: res.statusCode, body: data }));
    }).on('error', reject);
  });
}

function getSolvedPackages(level) {
  const levelDir = path.join(SRC_PATH, `level${level}`);
  if (!fs.existsSync(levelDir)) return [];
  return fs.readdirSync(levelDir, { withFileTypes: true })
    .filter(d => d.isDirectory())
    .map(d => d.name);
}

function toPackageName(title) {
  return title.replace(/\s+/g, '').replace(/[^가-힣a-zA-Z0-9_]/g, '');
}

async function getAllProblems() {
  process.stderr.write('[1/3] 전체 문제 목록 조회 중...\n');
  const perPage = 100;
  const allProblems = [];

  // 첫 페이지로 totalPages 파악
  const first = await get(`https://school.programmers.co.kr/api/v2/school/challenges/?perPage=${perPage}&page=1`);
  const firstData = JSON.parse(first.body);
  const totalPages = firstData.totalPages;
  allProblems.push(...(firstData.result || []));
  process.stderr.write(`  페이지 1/${totalPages} (총 ${firstData.totalEntries}개)\n`);

  // 나머지 페이지 순차 조회
  for (let page = 2; page <= totalPages; page++) {
    const res = await get(`https://school.programmers.co.kr/api/v2/school/challenges/?perPage=${perPage}&page=${page}`);
    const data = JSON.parse(res.body);
    allProblems.push(...(data.result || []));
    process.stderr.write(`  페이지 ${page}/${totalPages}\n`);
  }

  return allProblems;
}

async function getJavaMethod(id) {
  const res = await get(
    `https://school.programmers.co.kr/api/v1/school/challenges/${id}?language=java`,
    { ...BASE_HEADERS, Referer: `https://school.programmers.co.kr/learn/courses/30/lessons/${id}` }
  );
  const data = JSON.parse(res.body);
  const code = data.initialCode || '';

  // class Solution { ... } 에서 메소드 본문만 추출
  const match = code.match(/class Solution \{([\s\S]*)\}/);
  return match ? match[1].trim() : code;
}

async function getProblemDescription(id) {
  process.stderr.write('[3/3] 문제 설명 로딩 중...\n');
  const res = await get(
    `https://school.programmers.co.kr/learn/courses/30/lessons/${id}`,
    { ...BASE_HEADERS, Accept: 'text/html', 'Accept-Language': 'ko-KR,ko;q=0.9' }
  );

  const html = res.body;

  // .markdown.solarized-dark 내 HTML 추출
  const match = html.match(/<div class="markdown solarized-dark">([\s\S]*?)<\/div>\s*<\/div>\s*<\/div>/);
  if (!match) {
    // 대안 패턴
    const alt = html.match(/class="markdown[^"]*">([\s\S]*?)<\/div>/);
    if (alt) return htmlToText(alt[1]);
    return '(문제 설명을 가져오지 못했습니다. URL을 직접 확인해주세요.)';
  }

  return htmlToText(match[1]);
}

function htmlToText(html) {
  return html
    .replace(/<br\s*\/?>/gi, '\n')
    .replace(/<\/p>/gi, '\n')
    .replace(/<\/li>/gi, '\n')
    .replace(/<\/tr>/gi, '\n')
    .replace(/<\/h[1-6]>/gi, '\n')
    .replace(/<th[^>]*>(.*?)<\/th>/gi, '$1\t')
    .replace(/<td[^>]*>(.*?)<\/td>/gi, '$1\t')
    .replace(/<[^>]+>/g, '')
    .replace(/&lt;/g, '<')
    .replace(/&gt;/g, '>')
    .replace(/&amp;/g, '&')
    .replace(/&quot;/g, '"')
    .replace(/&#39;/g, "'")
    .replace(/&nbsp;/g, ' ')
    .replace(/\n{3,}/g, '\n\n')
    .trim();
}

async function main() {
  const solvedPackages = getSolvedPackages(level);
  process.stderr.write(`[0/3] 이미 푼 문제: ${solvedPackages.length}개\n`);

  const allProblems = await getAllProblems();

  // 레벨 필터링
  const levelProblems = allProblems.filter(p => p.level === level);
  process.stderr.write(`[2/3] 레벨 ${level} 문제: ${levelProblems.length}개\n`);

  // 미풀이 필터링
  const unsolved = levelProblems.filter(p => {
    const pkg = toPackageName(p.title);
    return !solvedPackages.includes(pkg);
  });
  process.stderr.write(`      미풀이: ${unsolved.length}개\n`);

  if (unsolved.length === 0) {
    process.stderr.write(`레벨 ${level} 문제를 모두 풀었습니다!\n`);
    process.exit(1);
  }

  // 랜덤 선택 (SQL 문제 제외)
  const candidates = [...unsolved].sort(() => Math.random() - 0.5);
  let selected = null;
  let javaMethod = null;
  for (const candidate of candidates) {
    const method = await getJavaMethod(candidate.id);
    if (!method.trim().startsWith('--')) {
      selected = candidate;
      javaMethod = method;
      break;
    }
    process.stderr.write(`      SQL 문제 제외: ${candidate.title}\n`);
  }

  if (!selected) {
    process.stderr.write(`레벨 ${level}에 풀 수 있는 Java 알고리즘 문제가 없습니다.\n`);
    process.exit(1);
  }

  const url = `https://school.programmers.co.kr/learn/courses/30/lessons/${selected.id}`;
  const description = await getProblemDescription(selected.id);

  console.log(JSON.stringify({
    title: selected.title,
    url,
    id: selected.id,
    packageName: toPackageName(selected.title),
    level,
    description,
    javaMethod
  }, null, 2));
}

main().catch(err => {
  process.stderr.write('Error: ' + err.message + '\n');
  process.exit(1);
});
