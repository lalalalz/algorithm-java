package test;

import leetCode.RemoveElement;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    RemoveElement solution = new RemoveElement();

    @Test
    void test1() {
        int[] nums = {3, 2, 2, 3};
        int k = solution.removeElement(nums, 3);
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }

    @Test
    void test2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int k = solution.removeElement(nums, 2);
        Arrays.sort(nums, 0, k);
        assertEquals(5, k);
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}