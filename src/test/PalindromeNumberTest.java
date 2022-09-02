package test;

import leetCode.PalindromeNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    PalindromeNumber palindromeNumber = new PalindromeNumber();

    @Test
    void test1() {
        boolean result = palindromeNumber.isPalindrome(121);
        assertTrue(result);
    }

    @Test
    void test2() {
        boolean result = palindromeNumber.isPalindrome(-121);
        assertFalse(result);
    }

    @Test
    void test3() {
        boolean result = palindromeNumber.isPalindrome(10);
        assertFalse(result);
    }
}