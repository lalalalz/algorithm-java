package test;

import level3.CodingStudy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodingStudyTest {

    CodingStudy codingStudy = new CodingStudy();

    @Test
    void test1() {
        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
        int result = codingStudy.solution(10, 10, problems);
        assertEquals(15, result);
    }

    @Test
    void test2() {
        int[][] problems = {{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}};
        int result = codingStudy.solution(0, 0, problems);
        assertEquals(13, result);
    }
}