package test;

import level2.MaxAndMin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAndMinTest {

    MaxAndMin maxAndMin = new MaxAndMin();

    @Test
    void test1() {
        String result = maxAndMin.solution("1 2 3 4");
        assertEquals(result.equals("1 4"), true);
    }

    @Test
    void test2() {
        String result = maxAndMin.solution("-1 -2 -3 -4");
        assertEquals(result.equals("-4 -1"), true);
    }

    @Test
    void test3() {
        String result = maxAndMin.solution("-1 -1");
        assertEquals(result.equals("-1 -1"), true);
    }
}