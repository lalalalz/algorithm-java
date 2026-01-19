package leetCode.p16;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    left++;
                    answer = abs(sum - target) > abs(answer - target) ? answer : sum;
                }
                else if (sum > target) {
                    right--;
                    answer = abs(sum - target) > abs(answer - target) ? answer : sum;
                }
                else {
                    return target;
                }
            }
        }

        return answer;
    }
}
