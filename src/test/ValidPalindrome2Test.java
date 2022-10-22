package test;

import leetCode.ValidPalindrome2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindrome2Test {

    ValidPalindrome2 solution = new ValidPalindrome2();

    @Test
    void test1() {
        boolean result = solution.validPalindrome("abc");
        assertFalse(result);
    }

    @Test
    void test2() {
        boolean result = solution.validPalindrome("aba");
        assertTrue(result);
    }

    @Test
    void test3() {
        boolean result = solution.validPalindrome("abca");
        assertTrue(result);
    }
}