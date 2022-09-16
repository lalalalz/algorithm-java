package test;

import leetCode.ValidParentheses;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    ValidParentheses solution = new ValidParentheses();

    @Test
    void test1() {
        boolean result = solution.isValid("()");
        assertTrue(result);
    }

    @Test
    void test2() {
        boolean result = solution.isValid("()[]{}");
        assertTrue(result);
    }

    @Test
    void test3() {
        boolean result = solution.isValid("(]");
        assertFalse(result);
    }

    @Test
    void test4() {
        boolean result = solution.isValid("([)]");
        assertFalse(result);
    }

    @Test
    void test5() {
        boolean result = solution.isValid("]");
        assertFalse(result);
    }

    @Test
    void myTest() {
        char[] a = {'a', 'b', 'c'};


    }
}