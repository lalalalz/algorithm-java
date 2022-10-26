package test;

import leetCode.PartitionArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionArrayTest {

    PartitionArray solution = new PartitionArray();

    @Test
    void test1() {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        boolean result = solution.canThreePartsEqualSum(arr);
        assertTrue(result);
    }

    @Test
    void test2() {
        int[] arr = {0,2,1,-6,6,7,9,-1,2,0,1};
        boolean result = solution.canThreePartsEqualSum(arr);
        assertFalse(result);
    }

    @Test
    void test3() {
        int[] arr = {3,3,6,5,-2,2,5,1,-9,4};
        boolean result = solution.canThreePartsEqualSum(arr);
        assertTrue(result);
    }
}