package test;

import leetCode.LongestSubstring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringTest {

    LongestSubstring solution = new LongestSubstring();

    @Test
    void test1() {
        int result = solution.lengthOfLongestSubstring("abcdefbaghi");
        Assertions.assertEquals(3, result);

    }

}