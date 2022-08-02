package test;

import level2.Lcm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcmTest {

    Lcm lcm = new Lcm();

    @Test
    void test1() {
        int[] input = {2, 6, 8, 14};
        int result = lcm.solution(input);
        assertEquals(168, result);
    }
}