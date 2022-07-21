package test;

import level2.BiggestSquare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiggestSquareTest {

    BiggestSquare biggestSquare = new BiggestSquare();

    @Test
    void test1() {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int result = biggestSquare.solution(board);
        assertEquals(result, 9);
    }

    @Test
    void test2() {
        int[][] board = {{0,0,1,1},{1,1,1,1}};
        int result = biggestSquare.solution(board);
        assertEquals(result, 4);
    }
}