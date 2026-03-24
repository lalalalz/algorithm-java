package level1.완주하지못한선수;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 완주 선수 맵 구성
        HashMap<String, Integer> completionMap = new HashMap<>();
        for (String s : completion) {
            completionMap.put(s, completionMap.getOrDefault(s, 0) + 1);
        }

        // 참가자 별 완주 확인
        for (String s : participant) {
            if (!completionMap.containsKey(s) || completionMap.get(s) == 0) {
                answer = s;
                break;
            }
            else {
                completionMap.put(s, completionMap.get(s) - 1);
            }
        }

        return answer;
    }
}
