package leetCode.p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> characterCountMap = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            characterCountMap.put(s.charAt(i), 0);
        }

        while (left < s.length()) {
            char leftCharacter = s.charAt(left);
            char rightCharacter = s.charAt(right);

            int rightCharacterCount = characterCountMap.get(rightCharacter);

            if (isDuplicated(rightCharacterCount)) {
                characterCountMap.put(leftCharacter, characterCountMap.get(leftCharacter) - 1);
                left++;
            }
            else {
                characterCountMap.put(rightCharacter, rightCharacterCount + 1);
                answer = Math.max(answer, right - left + 1);
                if (right + 1 < s.length()) {
                    right++;
                }
            }
        }

        return answer;
    }

    private static boolean isDuplicated(Integer rightCharacterCount) {
        return rightCharacterCount + 1 > 1;
    }
}
