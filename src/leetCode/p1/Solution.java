package leetCode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = generatePairs(nums);
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.value));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = pairs[left].value + pairs[right].value;

            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                return new int[]{pairs[left].index, pairs[right].index};
            }
        }

        return null;
    }

    private Pair[] generatePairs(int[] nums) {
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(i, nums[i]));
        }

        return pairs.toArray(new Pair[]{});
    }

    record Pair(int index, int value) {}
}

/**
 * class Solution {
 *     public int[] twoSum(int[] nums, int target) {
 *         Map<Integer, Integer> map = new HashMap<>();
 *         for (int i = 0; i < nums.length; i++) {
 *             int complement = target - nums[i];
 *             if (map.containsKey(complement)) {
 *                 return new int[] { map.get(complement), i };
 *             }
 *             map.put(nums[i], i);
 *         }
 *         // Return an empty array if no solution is found
 *         return new int[] {};
 *     }
 * }
 */