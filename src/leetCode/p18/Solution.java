package leetCode.p18;

import java.util.*;

public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        calcDistinctNums(nums);
        func(0, 0, calcDistinctNums(nums), new Stack<>(), target);
        return result;
    }

    private List<Pair> calcDistinctNums(int[] nums) {
        Map<Integer, Pair> distinctMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Pair pair = distinctMap.getOrDefault(nums[i], new Pair());
            pair.num = nums[i];
            pair.count++;
            distinctMap.put(nums[i], pair);
        }

        return distinctMap
                .values()
                .stream()
                .toList();
    }

    private void func(int index, int count, List<Pair> nums, Stack<Integer> stack, int target) {
        if (count == 4) {
            if (isSumOf(stack, target)) {
               result.add(stack.stream().toList());
               return;
            }
        }

        if (index >= nums.size()) {
            return;
        }

        // 사용안함
        func(index + 1, count, nums, stack, target);

        // 사용함
        Pair pair = nums.get(index);
        if (pair.count > 0) {
            stack.push(pair.num);
            pair.count--;
            func(index, count + 1, nums, stack, target);
            pair.count++;
            stack.pop();
        }
    }

    private static boolean isSumOf(Stack<Integer> stack, int target) {
        return stack
                .stream()
                .mapToInt(Integer::intValue)
                .sum() == target;
    }

    public static class Pair {
        int num;
        int count;
    }
}
