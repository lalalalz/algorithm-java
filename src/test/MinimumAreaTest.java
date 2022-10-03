package test;

import level1.MinimumArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAreaTest {

    MinimumArea minimumArea = new MinimumArea();

    @Test
    void test1() {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = minimumArea.solution(sizes);

        assertEquals(4000, result);
    }

}