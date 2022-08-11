package test;

import level3.ExpressInN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressInNTest {

    ExpressInN expressInN = new ExpressInN();

    @Test
    void test1() {
        int result = expressInN.solution(5, 12);
        assertEquals(4, result);
    }
}