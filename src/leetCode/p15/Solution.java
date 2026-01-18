package leetCode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int first = 0; first < n - 2; first++) {
            if (shouldSkipFirst(nums, first)) {
                continue;
            }
            if (nums[first] > 0) {
                break;
            }

            twoSum(nums, first, answer);
        }

        return answer;
    }

    private static boolean shouldSkipFirst(int[] nums, int first) {
        return first > 0 && nums[first] == nums[first - 1];
    }

    private static void twoSum(int[] nums, int first, List<List<Integer>> answer) {
        int target = -nums[first];
        int left = first + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                answer.add(List.of(nums[first], nums[left], nums[right]));
                left = nextDistinctLeft(nums, left, right);
                right = nextDistinctRight(nums, left, right);
            }
        }
    }

    private static int nextDistinctLeft(int[] nums, int left, int right) {
        int value = nums[left];
        while (left < right && nums[left] == value) {
            left++;
        }
        return left;
    }

    private static int nextDistinctRight(int[] nums, int left, int right) {
        int value = nums[right];
        while (left < right && nums[right] == value) {
            right--;
        }
        return right;
    }
}
