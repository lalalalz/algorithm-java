package test;

import level2.LongJump;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongJumpTest {

    LongJump longJump = new LongJump();

    @Test
    void test1() {
        long result = longJump.solution(4);
        assertEquals(5, result);
    }

    @Test
    void test2() {
        long result = longJump.solution(3);
        assertEquals(3, result);
    }
}