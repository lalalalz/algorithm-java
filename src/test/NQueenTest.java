package test;

import level2.NQueen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueenTest {

    NQueen nQueen = new NQueen();

    @Test
    void test1() {
        int result = nQueen.solution(4);
        assertEquals(2, result);
    }

}