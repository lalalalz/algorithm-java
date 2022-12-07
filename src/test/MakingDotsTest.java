package test;

import level2.MakingDots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingDotsTest {

    MakingDots makingDots = new MakingDots();

    @Test
    void test1() {
        long result = makingDots.solution(2, 4);
        assertEquals(6, result);
    }


}