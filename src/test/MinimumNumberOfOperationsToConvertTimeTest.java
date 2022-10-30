package test;

import leetCode.MinimumNumberOfOperationsToConvertTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfOperationsToConvertTimeTest {

    MinimumNumberOfOperationsToConvertTime solution = new MinimumNumberOfOperationsToConvertTime();

    @Test
    void test1() {
        int result = solution.convertTime("02:30", "04:35");
        assertEquals(result, 3);
    }

    @Test
    void test2() {
        int result = solution.convertTime("11:00", "11:01");
        assertEquals(result, 1);
    }
}