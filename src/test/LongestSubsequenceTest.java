package test;

import leetCode.LongestSubsequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubsequenceTest {

    LongestSubsequence solution = new LongestSubsequence();

    @Test
    void test1() {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] expected = {2, 3, 4};

        int[] result = solution.answerQueries(nums, queries);
        assertArrayEquals(expected, result);
    }

    @Test
    void test2() {
        int[] nums = {1};
        int[] queries = {1};
        int[] expected = {1};

        int[] result = solution.answerQueries(nums, queries);
        assertArrayEquals(expected, result);
    }
}