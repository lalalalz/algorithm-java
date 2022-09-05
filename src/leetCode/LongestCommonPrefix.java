package leetCode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strings) {
        String shortestString = getShortestString(strings);
        return getLongestCommonPrefix(0, shortestString, strings);
    }

    private String getShortestString(String[] strings) {
        return Arrays.stream(strings)
                .sorted()
                .findFirst()
                .get();
    }

    private String getLongestCommonPrefix(int index, String shortestString, String[] strings) {

        if (isAllSame(index, shortestString, strings)) {
            return getLongestCommonPrefix(index + 1, shortestString, strings);
        }

        return shortestString.substring(0, index);
    }

    private boolean isAllSame(int index, String shortestString, String[] strings) {
        if(index >= shortestString.length()) return false;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(index) != shortestString.charAt(index)) {
                return false;
            }
        }

        return true;
    }
}
