package test;

import level3.EstimateOfRacecourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstimateOfRacecourseTest {

    EstimateOfRacecourse estimateOfRacecourse = new EstimateOfRacecourse();

    @Test
    void test1() {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 1, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(4500, result);
    }

    @Test
    void test2() {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 1}, {0, 1, 1, 0, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(3000, result);
    }

    @Test
    void test3() {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(2100, result);
    }

    @Test
    void test4() {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(2100, result);
    }

    @Test
    void test5() {
        int[][] board = {{0, 0}, {1, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(700, result);
    }

    @Test
    void test6() {
        int[][] board = {{0, 0}, {0, 0}};
        int result = estimateOfRacecourse.solution(board);
        assertEquals(700, result);
    }

}