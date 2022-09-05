package test;

import leetCode.LongestCommonPrefix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

    LongestCommonPrefix solution = new LongestCommonPrefix();

    @Test
    void test1() {
        String[] strings = {"flower","flow","flight"};
        String result = solution.longestCommonPrefix(strings);
        Assertions.assertTrue(result.equals("fl"));
    }

    @Test
    void test2() {
        String[] strings = {"dog","racecar","car"};
        String result = solution.longestCommonPrefix(strings);
        Assertions.assertTrue(result.equals(""));
    }

}