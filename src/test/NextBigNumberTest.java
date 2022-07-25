package test;

import level2.NextBigNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextBigNumberTest {

    NextBigNumber nextBigNumber = new NextBigNumber();

    @Test
    void test1() {
        int result = nextBigNumber.solution(78);
        assertEquals(83, result);
    }

    @Test
    void test2() {
        int result = nextBigNumber.solution(15);
        assertEquals(23, result);
    }

    @Test
    void test3() {
        int result = nextBigNumber.solution(1000000);
        assertEquals(83, result);
    }
}