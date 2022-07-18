package test;

import level1.GetAverage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAverageTest {

    GetAverage getAverage = new GetAverage();

    @Test
    void test1() {
        int[] input = {1, 2, 3, 4};
        double result = getAverage.solution(input);
        assertEquals(result, 2.5);
    }

    @Test
    void test2() {
        int[] input = {5, 5};
        double result = getAverage.solution(input);
        assertEquals(result, 5);
    }

}