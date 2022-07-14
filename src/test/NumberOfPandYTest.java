package test;

import level1.programmers.NumberOfPandY;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfPandYTest {

    private NumberOfPandY numberOfPandY = new NumberOfPandY();

    @Test
    void test1() {
        String input = "pPoooyY";
        boolean isTrue = numberOfPandY.solution(input);
        assertEquals(true, isTrue);
    }

    @Test
    void test2() {
        String input = "Pyy";
        boolean isTrue = numberOfPandY.solution(input);
        assertEquals(false, isTrue);
    }

    @Test
    void test3() {
        String input = "abc";
        boolean isTrue = numberOfPandY.solution(input);
        assertEquals(true, isTrue);
    }
}