package test;

import level1.programmers.XAndNArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XAndNArrayTest {

    XAndNArray xAndNArray = new XAndNArray();

    @Test
    void test1() {
        long[] answer = {2, 4, 6, 8, 10};
        long[] result = xAndNArray.solution(2, 5);

        assertArrayEquals(result, answer);
    }

    @Test
    void test2() {
        long[] answer = {4, 8, 12};
        long[] result = xAndNArray.solution(4, 3);

        assertArrayEquals(result, answer);
    }

    @Test
    void test3() {
        long[] answer = {-4, -8};
        long[] result = xAndNArray.solution(-4, 2);

        assertArrayEquals(result, answer);
    }

}