package test;

import codility.Task1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeITask1Test {

    Task1 task1 = new Task1();

    @Test
    void test1() {
        int result = task1.solution(new int[]{3, 5, 1});
        assertEquals(9, result);

    }

}