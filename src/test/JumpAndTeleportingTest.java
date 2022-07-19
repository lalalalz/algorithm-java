package test;

import level2.JumpAndTeleporting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpAndTeleportingTest {

    JumpAndTeleporting jumpAndTeleporting = new JumpAndTeleporting();

    @Test
    void test1() {
        int result = jumpAndTeleporting.solution(5);
        assertEquals(result, 2);
    }

    @Test
    void test2() {
        int result = jumpAndTeleporting.solution(6);
        assertEquals(result, 2);
    }

    @Test
    void test3() {
        int result = jumpAndTeleporting.solution(5000);
        assertEquals(result, 5);
    }

    @Test
    void test4() {
        int result = jumpAndTeleporting.solution(100000000);
        assertEquals(result, 5);
    }
}