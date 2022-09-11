package leetCode;

import java.util.*;

public class ThreeSumVersion2 {

    private Set<List<Integer>> tripletSet = new HashSet<>();
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        generateCountMap(nums);
        findTripletsOfZeroSum(nums);
        return getTripletsFromSet();
    }

    private void generateCountMap(int[] nums) {
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }
    }

    private List<List<Integer>> getTripletsFromSet() {
        return tripletSet.stream().toList();
    }

    private void findTripletsOfZeroSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (canUsed(nums[i], nums[j], -(nums[i] + nums[j]))) {
                    tripletSet.add(Arrays.asList(nums[i], nums[j], -(nums[i]), nums[j]));
                }
            }
        }
    }

    private boolean canUsed(int first, int second, int third) {
        if(decreaseCount(first, second, third) >= 0) {
            return false;
        }

        return true;
    }

    private int decreaseCount(int first, int second, int third) {
        int sum = 0;

        int firstCount = countMap.getOrDefault(first, -1);
        sum = firstCount - 1;

        int secondCount = countMap.getOrDefault(second, -1);
        sum = secondCount - 1;

        int thirdCount = countMap.getOrDefault(third, -1);
        sum = thirdCount - 1;

        return sum;
    }
}
