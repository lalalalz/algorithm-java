package test;

import leetCode.LongestPalindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {


    LongestPalindrome solution = new LongestPalindrome();

    @Test
    void test1() {
        int result = solution.longestPalindrome("abccccdd");
        assertEquals(7, result);
    }

    @Test
    void test2() {
        int result = solution.longestPalindrome("a");
        assertEquals(1, result);
    }

}