package test;

import codility.array.Task1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    Task1 task1 = new Task1();

    @Test
    void test1() {
        int result = task1.solution(1041);
        assertEquals(5, result);
    }

    @Test
    void test2() {
        int result = task1.solution(32);
        assertEquals(0, result);
    }

    @Test
    void test3() {
        int result = task1.solution(9);
        assertEquals(2, result);
    }

}