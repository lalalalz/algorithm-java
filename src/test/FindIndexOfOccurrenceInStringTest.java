package test;

import leetCode.FindIndexOfOccurrenceInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindIndexOfOccurrenceInStringTest {

    FindIndexOfOccurrenceInString solution = new FindIndexOfOccurrenceInString();

    @Test
    void test1() {
        int result = solution.strStr("leetcode", "leeto");
        assertEquals(-1, result);
    }

}