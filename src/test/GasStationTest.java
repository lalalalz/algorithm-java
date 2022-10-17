package test;

import leetCode.GasStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    GasStation solution = new GasStation();

    @Test
    void test1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }

    @Test
    void test2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    void test3() {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }
}