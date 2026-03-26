#!/usr/bin/env node
/**
 * 프로그래머스 솔루션 제출 스크립트
 * Usage: node submit_solution.js <solution_file_path>
 * Output: JSON { score, result, passed, total, testcases }
 */

const path = require('path');
require('dotenv').config({ path: path.join(__dirname, '..', '.env') });
const puppeteer = require('puppeteer');
const fs = require('fs');
const https = require('https');

const solutionFile = process.argv[2];
if (!solutionFile) {
  process.stderr.write('Usage: node submit_solution.js <solution_file_path>\n');
  process.exit(1);
}

function parseSolutionFile(filePath) {
  const content = fs.readFileSync(filePath, 'utf-8');

  const urlMatch = content.match(/\*\s*URL:\s*(https:\/\/school\.programmers\.co\.kr\/learn\/courses\/30\/lessons\/(\d+))/);
  if (!urlMatch) throw new Error('Solution.java에서 URL 주석을 찾을 수 없습니다. (* URL: https://... 형식)');

  const url = urlMatch[1];
  const lessonId = parseInt(urlMatch[2]);

  // 에디터에 주입할 코드: package 선언, Javadoc, public 제거
  const editorCode = content
    .replace(/^package [^;]+;\s*\n/m, '')
    .replace(/\/\*\*[\s\S]*?\*\/\s*/g, '')
    .replace(/\bpublic class Solution\b/, 'class Solution')
    .trim();

  return { url, lessonId, editorCode };
}

function fetchJson(url, cookies) {
  return new Promise((resolve, reject) => {
    const cookieStr = cookies.map(c => `${c.name}=${c.value}`).join('; ');
    https.get(url, {
      headers: {
        'Cookie': cookieStr,
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36',
        'Accept': 'application/json'
      }
    }, res => {
      let data = '';
      res.on('data', chunk => data += chunk);
      res.on('end', () => {
        try { resolve(JSON.parse(data)); }
        catch (e) { reject(new Error('JSON 파싱 실패: ' + data.slice(0, 100))); }
      });
    }).on('error', reject);
  });
}

async function main() {
  const email = process.env.PROGRAMMERS_EMAIL;
  const password = process.env.PROGRAMMERS_PASSWORD;
  if (!email || !password) {
    throw new Error('.env에 PROGRAMMERS_EMAIL과 PROGRAMMERS_PASSWORD를 설정해주세요.');
  }

  const { url, lessonId, editorCode } = parseSolutionFile(path.resolve(solutionFile));
  process.stderr.write(`제출 문제: ${url}\n`);

  const browser = await puppeteer.launch({
    executablePath: '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',
    headless: true,
    args: ['--no-sandbox', '--disable-setuid-sandbox']
  });

  try {
    const page = await browser.newPage();
    await page.setViewport({ width: 1280, height: 900 });

    // 로그인
    await page.goto('https://school.programmers.co.kr', { waitUntil: 'domcontentloaded', timeout: 30000 });
    const loginResult = await page.evaluate(async (email, password) => {
      const res = await fetch('https://school.programmers.co.kr/api/v1/account/sign-in', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ user: { email, password } }),
        credentials: 'include'
      });
      return { status: res.status };
    }, email, password);

    if (loginResult.status !== 200) throw new Error(`로그인 실패 (HTTP ${loginResult.status})`);
    process.stderr.write('로그인 완료\n');

    // 문제 페이지로 이동
    process.stderr.write('문제 페이지 로딩 중...\n');
    await page.goto(url, { waitUntil: 'networkidle2', timeout: 60000 });
    await new Promise(r => setTimeout(r, 1500));

    // 튜토리얼 팝업 닫기 (있는 경우)
    await page.evaluate(() => {
      const btns = Array.from(document.querySelectorAll('button'));
      // "×" 닫기 버튼 우선
      const closeBtn = btns.find(b => b.className.includes('close') || b.textContent.trim() === '×');
      if (closeBtn) { closeBtn.click(); return; }
      // 없으면 ESC로 닫기 시도
    }).catch(() => {});
    await page.keyboard.press('Escape');
    await new Promise(r => setTimeout(r, 500));

    // 언어 확인 및 Java로 변경 (네비게이션 대비)
    const currentLang = await page.evaluate(() => {
      const btn = document.querySelector('.btn.btn-dark.dropdown-toggle');
      return btn ? btn.textContent.trim() : '';
    });
    const isJava = currentLang.toLowerCase().includes('java') && !currentLang.toLowerCase().includes('javascript');

    if (!isJava) {
      process.stderr.write(`현재 언어: ${currentLang} → Java로 변경 중...\n`);
      // 네비게이션 대기를 클릭 전에 등록
      const navPromise = page.waitForNavigation({ waitUntil: 'networkidle2', timeout: 15000 }).catch(() => null);
      await page.evaluate(() => {
        const btn = document.querySelector('.btn.btn-dark.dropdown-toggle');
        if (btn) btn.click();
      });
      await new Promise(r => setTimeout(r, 500));
      // evaluateHandle로 Java 항목의 DOM 핸들 획득
      const javaHandle = await page.evaluateHandle(() => {
        const items = Array.from(document.querySelectorAll('.dropdown-menu li a, .dropdown-item'));
        return items.find(el => {
          const t = el.textContent.trim().toLowerCase();
          return t === 'java' || t === 'java 11' || t === 'java 17' || t === 'java 21';
        }) || null;
      });
      const javaEl = javaHandle.asElement();
      if (javaEl) {
        const javaText = await page.evaluate(el => el.textContent.trim(), javaEl);
        await javaEl.click(); // Puppeteer 네이티브 클릭 (context 파괴에 안전)
        await navPromise;     // 네비게이션 발생 시 완료 대기
        process.stderr.write(`언어 변경: ${javaText}\n`);
        // 에디터가 완전히 초기화될 때까지 대기
        await page.waitForFunction(
          () => {
            const cm = document.querySelector('.CodeMirror');
            return cm && cm.CodeMirror && cm.CodeMirror.getValue().length > 0;
          },
          { timeout: 10000 }
        ).catch(() => {});
        await new Promise(r => setTimeout(r, 500));
      } else {
        process.stderr.write('Java 항목을 찾지 못했습니다. 현재 언어로 진행합니다.\n');
      }
    } else {
      process.stderr.write(`언어: Java (이미 선택됨)\n`);
    }

    // CodeMirror 에디터에 코드 주입
    process.stderr.write('코드 주입 중...\n');
    const codeInjected = await page.evaluate((code) => {
      const cmEl = document.querySelector('.CodeMirror');
      if (!cmEl || !cmEl.CodeMirror) return false;
      cmEl.CodeMirror.setValue(code);
      return true;
    }, editorCode);
    process.stderr.write(`코드 주입: ${codeInjected ? '성공' : '실패 (기존 코드 유지)'}\n`);

    // 제출 버튼 클릭
    process.stderr.write('제출 중...\n');
    await page.evaluate(() => {
      const btns = Array.from(document.querySelectorAll('button'));
      const btn = btns.find(b => b.textContent.includes('제출 후 채점'));
      if (btn) btn.click();
    });

    // 결과 모달 대기 (최대 120초)
    process.stderr.write('채점 대기 중...\n');
    const resultText = await page.evaluate(() => {
      return new Promise((resolve, reject) => {
        const deadline = Date.now() + 120000;
        const timer = setInterval(() => {
          // 결과 모달 제목 확인
          const modalTitle = document.querySelector('.modal-title, h4.modal-title, [class*="result-title"]');
          if (modalTitle) {
            const text = modalTitle.textContent.trim();
            if (text.includes('정답') || text.includes('틀렸') || text.includes('에러') || text.includes('시간')) {
              clearInterval(timer);
              resolve(text);
              return;
            }
          }
          // 채점 결과 영역 확인
          const resultArea = document.querySelector('[class*="result"], .tab-pane');
          if (resultArea) {
            const text = resultArea.textContent;
            if (text.includes('정답입니다') || text.includes('틀렸습니다') || text.includes('런타임 에러')) {
              clearInterval(timer);
              resolve(text.trim().slice(0, 200));
              return;
            }
          }
          if (Date.now() > deadline) {
            clearInterval(timer);
            reject(new Error('채점 시간 초과 (2분)'));
          }
        }, 1000);
      });
    });

    process.stderr.write(`결과 텍스트: ${resultText.slice(0, 100)}\n`);

    // 쿠키 수집 후 제출 내역 API 조회
    const cookies = await page.cookies();
    const isCorrect = resultText.includes('정답');

    let score = isCorrect ? 100 : 0;
    let passed = null;
    let total = null;

    try {
      const submissions = await fetchJson(
        `https://programmers.co.kr/api/v1/school/open-challenge/lessons/${lessonId}/submissions?page=1&perPage=1`,
        cookies
      );
      if (submissions.submissions && submissions.submissions[0]) {
        const latest = submissions.submissions[0];
        score = latest.score ?? score;
        passed = latest.passed_testcase_count ?? null;
        total = latest.total_testcase_count ?? null;
        process.stderr.write(`제출 내역 조회 완료: score=${score}\n`);
      }
    } catch (e) {
      process.stderr.write(`제출 내역 조회 실패: ${e.message}\n`);
    }

    const finalResult = score === 100 ? 'pass' : (isCorrect ? 'pass' : 'fail');
    const finalMessage = score === 100 ? '정답입니다!' : (score > 0 ? `${score}점` : resultText.slice(0, 200));
    console.log(JSON.stringify({
      result: finalResult,
      score,
      passed,
      total,
      message: finalMessage
    }, null, 2));

  } finally {
    await browser.close();
  }
}

main().catch(err => {
  process.stderr.write('Error: ' + err.message + '\n');
  process.exit(1);
});
