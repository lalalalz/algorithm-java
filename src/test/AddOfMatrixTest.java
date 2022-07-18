package test;

import level1.AddOfMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOfMatrixTest {

    AddOfMatrix addOfMatrix = new AddOfMatrix();

    @Test
    void test1() {
        int[][] input1 = {{1, 2}, {2, 3}};
        int[][] input2 = {{3, 4}, {5, 6}};
        int[][] output = {{4, 6}, {7, 9}};

        int[][] result = addOfMatrix.solution(input1, input2);

        assertArrayEquals(result, output);
    }

    @Test
    void test2() {
        int[][] input1 = {{1}, {2}};
        int[][] input2 = {{3}, {4}};
        int[][] output = {{4}, {6}};

        int[][] result = addOfMatrix.solution(input1, input2);

        assertArrayEquals(result, output);
    }
}