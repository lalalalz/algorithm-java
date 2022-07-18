package test;

import level1.SquareRoot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    SquareRoot squareRoot = new SquareRoot();

    @Test
    void test1() {
        long result = squareRoot.solution(121);
        assertEquals(result, 144);
    }

    @Test
    void test2() {
        long result = squareRoot.solution(3);
        assertEquals(result, -1);
    }
}