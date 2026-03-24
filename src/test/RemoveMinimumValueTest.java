package test;

import org.junit.jupiter.api.Test;
import temp.RemoveMinimumValue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveMinimumValueTest {

    RemoveMinimumValue removeMinimumValue = new RemoveMinimumValue();

    @Test
    void test1() {
        int[] input = {1, 2, 3, 4};
        int[] output = {2, 3, 4};

        int[] answer = removeMinimumValue.solution(input);
        assertArrayEquals(output, answer);
    }

    @Test
    void test2() {
        int[] input = {4, 3, 2, 1};
        int[] output = {4, 3, 2};

        int[] answer = removeMinimumValue.solution(input);
        assertArrayEquals(output, answer);
    }

    @Test
    void test3() {
        int[] input = {10};
        int[] output = {-1};

        int[] answer = removeMinimumValue.solution(input);
        assertArrayEquals(output, answer);
    }
}