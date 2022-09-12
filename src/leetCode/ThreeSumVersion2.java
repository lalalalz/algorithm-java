package leetCode;

import java.util.*;

public class ThreeSumVersion2 {

    private Set<List<Integer>> tripletSet = new HashSet<>();
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
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
                int first = nums[i];
                int second = nums[j];
                int third = -(nums[i] + nums[j]);

                if (third >= second && canUsed(first, second, third)) {
                    tripletSet.add(Arrays.asList(first, second, third));
                }
            }
        }
    }

    private boolean canUsed(int first, int second, int third) {
        return decreaseCount(first, second, third);
    }

    private boolean decreaseCount(int first, int second, int third) {
        HashMap<Integer, Integer> count = new HashMap<>();

        initCount(first, count);
        initCount(second, count);
        initCount(third, count);

        decrease(first, count);
        decrease(second, count);
        decrease(third, count);

        for (Map.Entry<Integer, Integer> element : count.entrySet()) {
            if (element.getValue() < 0) {
                return false;
            }
        }

        return true;
    }

    private void decrease(int first, HashMap<Integer, Integer> count) {
        count.put(first, count.get(first) - 1);
    }

    private void initCount(int first, HashMap<Integer, Integer> count) {
        count.put(first, countMap.getOrDefault(first, -3000));
    }
}
