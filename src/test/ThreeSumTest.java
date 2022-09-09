package test;

import leetCode.ThreeSum;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTest {

    ThreeSum solution = new ThreeSum();

    @Test
    void test1() {
        int[] nums = {-1, 0, 1, 2, -1, 4};

        List<List<Integer>> result = solution.threeSum(nums);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("result.get(i).get(0) = " + result.get(i).get(0));
            System.out.println("result.get(i).get(0) = " + result.get(i).get(1));
            System.out.println("result.get(i).get(0) = " + result.get(i).get(2));

            System.out.println("===============================================");
        }
    }


    @Test
    void test2() {
        int[] nums = {0,1,1};

        List<List<Integer>> result = solution.threeSum(nums);

        for (int i = 0; i < result.size(); i++) {
            System.out.println("result.get(i).get(0) = " + result.get(i).get(0));
            System.out.println("result.get(i).get(0) = " + result.get(i).get(1));
            System.out.println("result.get(i).get(0) = " + result.get(i).get(2));

            System.out.println("===============================================");
        }
    }

}