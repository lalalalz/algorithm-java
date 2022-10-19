package test;

import leetCode.RemoveDuplicateLetters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicateLettersTest {

    RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

    @Test
    void test1() {
        String result = solution.removeDuplicateLetters("bcabc");
        System.out.println("result = " + result);
        assertTrue(result.equals("abc"));
    }

    @Test
    void test2() {
        String result = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println("result = " + result);
        assertTrue(result.equals("acdb"));
    }
}