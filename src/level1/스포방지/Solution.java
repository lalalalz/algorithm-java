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
        int solution1 = solution.solution("my phone number is 01012345678 and may i have your phone number", new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}});
        System.out.println("solution1 = " + solution1);
    }

    public int solution(String message, int[][] spoilerRanges) {
        int answer = 0;
        StringBuilder blindMessage = new StringBuilder(message);

        // 스포 방지 처리
        for (int[] spoilerRange : spoilerRanges) {
            for (int i = spoilerRange[0]; i <= spoilerRange[1]; i++) {
                if (blindMessage.charAt(i) != ' ') {
                    blindMessage.setCharAt(i, '*');
                }
            }
        }

        // 스포일러 문자 구분
        Set<String> spoilerWord = Arrays
                .stream(blindMessage
                        .toString()
                        .split(" "))
                .filter(word -> !word.contains("*"))
                .collect(Collectors.toSet());

        // 중요 문자 구분하기
        for (String word : message.split(" ")) {
            if (!spoilerWord.contains(word)) {
                answer++;
                spoilerWord.add(word);
            }
        }

        return answer;
    }

    public int solution2(String message, int[][] spoilerRanges) {
        // 단어별로 나눈다.
        String[] numbering = numberingOfWord(message);

        // 스티커를 붙이고, 스티커에 붙은 단어의 넘버를 반환한다.
        List<Set<Integer>> stickingResult = sticking(numbering, spoilerRanges);

        // 논 스포일러 목록을 구한다.
        Set<String> nonSpoilers = getNonSpoilers(numbering, stickingResult);

        // 스티커를 하나씩 떼면서, 중요 단어인지 확인한다.
        Set<String> spoilers = new HashSet<>();
        for (Set<Integer> stuckWordNumbers : stickingResult) {
            for (Integer stuckWordNumber : stuckWordNumbers) {
                String word = numbering[stuckWordNumber];
                if (!nonSpoilers.contains(word) && !spoilers.contains(word)) {
                    spoilers.add(word);
                }
            }
        }

        return spoilers.size();
    }

    private Set<String> getNonSpoilers(String[] numbering, List<Set<Integer>> stickingResult) {
        Set<Integer> spoilerNumbers = stickingResult
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        Set<String> nonSpoilers = new HashSet<>();
        for (int i = 0; i < numbering.length; i++) {
            if (!spoilerNumbers.contains(i)) {
                nonSpoilers.add(numbering[i]);
            }
        }

        return nonSpoilers;
    }

    private List<Set<Integer>> sticking(String[] numbering, int[][] spoilerRanges) {
        List<Set<Integer>> stickingResult = new ArrayList<>();

        for (int[] spoilerRange : spoilerRanges) {
            int startOfSpoiler = spoilerRange[0];
            int endOfSpoiler = spoilerRange[1];
            stickingResult.add(getIntegers(numbering, startOfSpoiler, endOfSpoiler));
        }

        return stickingResult;
    }

    private static Set<Integer> getIntegers(String[] numbering, int startOfSpoiler, int endOfSpoiler) {
        Set<Integer> stuckWordNumbers = new HashSet<>();
        int pos = 0;

        for (int i = 0; i < numbering.length; i++) {
            String word = numbering[i];
            int wordStart = pos;
            int wordEnd = pos + word.length() - 1;

            if (wordStart <= endOfSpoiler && wordEnd >= startOfSpoiler) {
                stuckWordNumbers.add(i);
            }

            pos += word.length() + 1; // +1 for space
        }

        return stuckWordNumbers;
    }

    private String[] numberingOfWord(String message) {
        return message.split(" ");
    }
}