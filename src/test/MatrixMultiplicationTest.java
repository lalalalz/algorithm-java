package test;

import level2.MatrixMultiplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMultiplicationTest {

    MatrixMultiplication matrixMultiplication = new MatrixMultiplication();

    @Test
    void test1() {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] answer = {{15, 15}, {15, 15}, {15, 15}};

        int[][] result = matrixMultiplication.solution(arr1, arr2);
        assertArrayEquals(answer, result);
    }

    @Test
    void test2() {
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] answer = {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}};

        int[][] result = matrixMultiplication.solution(arr1, arr2);
        assertArrayEquals(answer, result);
    }

}