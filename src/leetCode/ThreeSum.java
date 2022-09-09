package leetCode;

import java.util.*;

public class ThreeSum {

    private List<List<Integer>> triplets = new ArrayList<>();
    private HashMap<Integer, Integer> countMap = new HashMap<>();

    private static final int pivot = 50000;
    private int[] countOfNumber = new int[100001];

    public List<List<Integer>> threeSum(int[] nums) {
        generateCountMap(nums);
//        findTripletsOfZeroSum(0, new int[3], nums);
        return triplets;
    }

    private void generateCountMap(int[] nums) {
        for (int num : nums) {
            countOfNumber[num + pivot]++;
        }
    }

//    private void generateCountMap(int[] nums) {
//        for (int num : nums) {
//            Integer count = countMap.getOrDefault(num, 0);
//            countMap.put(num, count + 1);
//        }
//    }

    private void findTripletsOfZeroSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (countOfNumber[nums[i]] >= 0 && countOfNumber[nums[j]] >= 0) {

                }
            }
        }
    }

//    private void findTripletsOfZeroSum(int index, int[] triplet, int[] nums) {
//
//        if (index == 2) {
//            if (isZeroOfSum(triplet)) {
//                triplets.add(generateTripletList(triplet));
//            }
//            return;
//        }
//
//        for (Map.Entry<Integer, Integer> element : countMap.entrySet()) {
//            Integer num = element.getKey();
//            Integer count = element.getValue();
//
//            if (count > 0) {
//                triplet[index] = num;
//                countMap.put(num, count - 1);
//                findTripletsOfZeroSum(index + 1, triplet, nums);
//                countMap.put(num, count + 1);
//            }
//        }
//    }

//    private List<Integer> generateTripletList(int[] triplet) {
//        List<Integer> tripletList = new ArrayList<>();
//
//        for (int num : triplet) {
//            tripletList.add(num);
//        }
//
//        return tripletList;
//    }

    private boolean isZeroOfSum(int[] triplet) {
        return Arrays.stream(triplet).sum() == 0;
    }
}
