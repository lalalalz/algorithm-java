package level1.스포방지;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 스포 방지 구간을 클릭해 단어의 모든 문자가 공개되었을 때, 그 단어가 아래 조건을 모두 만족하면 중요한 단어입니다.
 * 스포 방지 단어여야 합니다.
 * 메시지의 스포 방지 구간이 아닌 구간(= 어떤 스포 방지 구간에도 속하지 않는 모든 구간: 각 구간의 앞·사이·뒤 포함)에 등장한 적이 없어야 합니다.
 * 이전에 공개된 스포 방지 단어와 중복되지 않아야 합니다.
 * 여러 단어가 동시에 공개된 경우, 왼쪽부터 순서대로 하나씩 중요한 단어인지 판단합니다.
 * <p>
 * <p>
 * 1 ≤ message의 길이 ≤ 20,000
 * message는 알파벳 소문자, 숫자 그리고 공백으로 이루어져 있습니다.
 * message는 하나 이상의 단어로 구성된 문자열입니다.
 * 공백은 연속해서 등장하지 않습니다.
 * 1 ≤ spoiler_ranges의 길이 ≤ 1,000
 * spoiler_ranges[i]는 [start, end] 형태로 스포 방지를 적용한 구간을 나타냅니다. 이때 start와 end는 문자 인덱스이며, 두 인덱스 모두 구간에 포함됩니다.
 * 0 ≤ start ≤ end < message의 길이
 * 모든 구간은 서로 겹치지 않으며, start 기준으로 오름차순 정렬되어 주어집니다.
 *
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("my phone number is 01012345678 and may i have your phone number", new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}});
        System.out.println("result = " + result);
    }

    public int solution(String message, int[][] spoilerRanges) {
        int answer = 0;
        String maskedMessage = buildMaskedMessage(message, spoilerRanges);
        Set<String> nonSpoilerWords = collectNonSpoilerWords(maskedMessage);
        Set<String> counted = new HashSet<>();

        for (String word : message.split(" ")) {
            if (!nonSpoilerWords.contains(word) && !counted.contains(word)) {
                answer++;
                counted.add(word);
            }
        }

        return answer;
    }

    private String buildMaskedMessage(String message, int[][] spoilerRanges) {
        StringBuilder masked = new StringBuilder(message);
        for (int[] range : spoilerRanges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (masked.charAt(i) != ' ') {
                    masked.setCharAt(i, '*');
                }
            }
        }
        return masked.toString();
    }

    private Set<String> collectNonSpoilerWords(String maskedMessage) {
        return Arrays.stream(maskedMessage.split(" "))
                .filter(word -> !word.contains("*"))
                .collect(Collectors.toSet());
    }
}