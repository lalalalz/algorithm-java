package test;

import level1.programmers.CollatsConjecture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollatsConjectureTest {

    CollatsConjecture collatsConjecture = new CollatsConjecture();

    @Test
    void test1() {
        int result = collatsConjecture.solution(6);
        assertEquals(result, 8);
    }

    @Test
    void test2() {
        int result = collatsConjecture.solution(16);
        assertEquals(result, 4);
    }

    @Test
    void test3() {
        int result = collatsConjecture.solution(626331);
        assertEquals(result, -1);
    }

    @Test
    void test4() {
        int result = collatsConjecture.solution(7999999);
        assertEquals(result, -1);
    }

    @Test
    void test5() {
        int result = collatsConjecture.solution(7999999);
        assertEquals(result, -1);
    }
}
