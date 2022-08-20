package test;

import codility.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {


    Palindrome palindrome = new Palindrome();

    @Test
    void test1() {

        String result = palindrome.solution("39878");
        assertEquals(true, result.equals("898"));
    }

}