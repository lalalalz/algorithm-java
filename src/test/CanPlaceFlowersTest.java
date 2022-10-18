package test;

import leetCode.CanPlaceFlowers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {

    CanPlaceFlowers solution = new CanPlaceFlowers();

    @Test
    void test1() {
        int n = 1;
        int[] flowerbed = {1, 0, 0, 0, 1};
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        assertTrue(result);
    }

    @Test
    void test2() {
        int n = 2;
        int[] flowerbed = {1, 0, 0, 0, 1};
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        assertFalse(result);
    }

    @Test
    void test3() {
        int n = 1;
        int[] flowerbed = {0, 1, 0, 1, 0, 1};
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        assertFalse(result);
    }

    @Test
    void test4() {
        int n = 2;
        int[] flowerbed = {1,0,0,0,1,0,0};
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        assertTrue(result);
    }
}