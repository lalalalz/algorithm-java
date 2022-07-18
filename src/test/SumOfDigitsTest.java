package test;

import level1.SumOfDigits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {

    SumOfDigits sumOfDigits = new SumOfDigits();

    @Test
    void test1() {
        int sum = sumOfDigits.solution(123);
        assertEquals(6, sum);
    }

    @Test
    void test2() {
        int sum = sumOfDigits.solution(987);
        assertEquals(24, sum);
    }

    @Test
    void test3() {
        int sum = sumOfDigits.solution(100000000);
        assertEquals(1, sum);
    }

}