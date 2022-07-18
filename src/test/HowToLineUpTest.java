package test;

import level2.HowToLineUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowToLineUpTest {

    HowToLineUp howToLineUp = new HowToLineUp();

    @Test
    void test1() {
        int[] answer = {3, 1, 2};
        int n = 3;
        int k = 5;

        int[] result = howToLineUp.solution(n, k);
        assertArrayEquals(result, answer);
    }

    @Test
    void test2() {
        int[] answer = {1, 4, 2, 3};
        int n = 4;
        int k = 5;

        int[] result = howToLineUp.solution(n, k);
        assertArrayEquals(result, answer);
    }
}