package test;

import level3.NumberTriangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTriangleTest {

    NumberTriangle numberTriangle = new NumberTriangle();

    @Test
    void test1() {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = numberTriangle.solution(triangle);
        assertEquals(30, result);
    }

}