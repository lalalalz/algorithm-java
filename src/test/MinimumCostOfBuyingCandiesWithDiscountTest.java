package test;

import leetCode.MinimumCostOfBuyingCandiesWithDiscount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostOfBuyingCandiesWithDiscountTest {

    MinimumCostOfBuyingCandiesWithDiscount solution =
            new MinimumCostOfBuyingCandiesWithDiscount();

    @Test
    void test1() {
        int[] cost = {1, 2, 3};
        int result = solution.minimumCost(cost);
        assertEquals(result, 5);
    }

    @Test
    void test2() {
        int[] cost = {6,5,7,9,2,2};
        int result = solution.minimumCost(cost);
        assertEquals(result, 23);
    }

    @Test
    void test3() {
        int[] cost = {5, 5};
        int result = solution.minimumCost(cost);
        assertEquals(result, 10);
    }
}