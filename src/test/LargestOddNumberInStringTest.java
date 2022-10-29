package test;

import leetCode.LargestOddNumberInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestOddNumberInStringTest {

    LargestOddNumberInString solution = new LargestOddNumberInString();

    @Test
    void test1() {
        String result = solution.largestOddNumber("52");
        assertTrue(result.equals("5"));
    }

    @Test
    void test2() {
        String result = solution.largestOddNumber("4206");
        assertTrue(result.equals(""));
    }

    @Test
    void test3() {
        String result = solution.largestOddNumber("35427");
        assertTrue(result.equals("35427"));
    }

}