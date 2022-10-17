package test;

import leetCode.BestTimeToBuyAndSellStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    @Test
    void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = solution.maxProfit(prices);
        assertEquals(7, result);
    }

    @Test
    void test2() {
        int[] prices = {1,2,3,4,5};
        int result = solution.maxProfit(prices);
        assertEquals(4, result);
    }

    @Test
    void test3() {
        int[] prices = {7,6,4,3,1};
        int result = solution.maxProfit(prices);
        assertEquals(0, result);
    }
}