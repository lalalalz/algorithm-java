package leetCode;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String str) {
        
        int lengthOfLongest = 0;
        HashMap<Character, Boolean> isUsed = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!isUsed.getOrDefault(ch, false)) {
                isUsed.put(ch, true);
                stringBuilder.append(ch);
            }
            else {
                lengthOfLongest = Math.max(lengthOfLongest, stringBuilder.toString().length());
                String repeatingSubstring = stringBuilder.substring(0, stringBuilder.indexOf(String.valueOf(ch)) + 1);
                String substring = stringBuilder.substring(stringBuilder.indexOf(String.valueOf(ch)) + 1);
                stringBuilder.replace(0, stringBuilder.length(), substring);
                stringBuilder.append(ch);

                for (char removedCharacter : repeatingSubstring.toCharArray()) {
                    isUsed.put(ch, false);
                }

                isUsed.put(ch, true);
            }
        }

        lengthOfLongest = Math.max(lengthOfLongest, stringBuilder.toString().length());
        System.out.println("stringBuilder = " + stringBuilder.toString());
        return lengthOfLongest;
    }
}
