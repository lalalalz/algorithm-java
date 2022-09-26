package test;

import leetCode.ContainerWithMostWater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    void test1() {

        int[] heights = {1, 2, 3, 4};

        int maxArea = solution.maxArea(heights);

        System.out.println("maxArea = " + maxArea);
    }
    
}