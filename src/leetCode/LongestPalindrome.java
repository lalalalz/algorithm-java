package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        return getLongestPalindromeLength(s);
    }

    private int getLongestPalindromeLength(String s) {
        int result = 0;
        boolean isOddNumberUsed = false;
        HashMap<Character, Integer> countOfCharacters = getCountOfCharacters(s);

        for (Map.Entry<Character, Integer> element : countOfCharacters.entrySet()) {
            int count = element.getValue();

            if (count % 2 > 0) {
                result += isOddNumberUsed ? count - 1 : count;
                isOddNumberUsed = true;
            }
            else {
                result += count;
            }
        }

        return result;
    }

    private HashMap<Character, Integer> getCountOfCharacters(String s) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            int count = result.getOrDefault(currentCharacter, 0);
            result.put(currentCharacter, count + 1);
        }

        return result;
    }

}
