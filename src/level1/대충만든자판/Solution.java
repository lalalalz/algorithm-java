package level1.대충만든자판;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // 각 문자열의 최소 횟수 매핑 생성
        for (String s : keymap) {
            for (int typingCount = 0; typingCount < s.length(); typingCount++) {
                Integer minimumCount = map.getOrDefault(s.charAt(typingCount), Integer.MAX_VALUE);
                map.put(s.charAt(typingCount), Math.min(minimumCount, typingCount + 1));
            }
        }

        // 모든 목표 문자열에 대해 최소 횟수를 구한다.
        for (String target : targets) {
            int totalCount = 0;

            // 각 문자열에 대한 최소 횟수를 구한다.
            for (int i = 0; i < target.length(); i++) {
                if (map.containsKey(target.charAt(i))) {
                    totalCount += map.get(target.charAt(i));
                }
                else {
                    totalCount = -1;
                    break;
                }
            }

            answer.add(totalCount);
        }

        return answer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
