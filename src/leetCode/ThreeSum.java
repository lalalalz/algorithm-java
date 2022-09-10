package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    private List<List<Integer>> triplets = new ArrayList<>();
//    private HashMap<Integer, Integer> countMap = new HashMap<>();

    private static final int pivot = 10000;
    private int[] countOfNumber = new int[20000 + 1];

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        generateCountMap(nums);
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        findTripletsOfZeroSum(distinct);
        return triplets.stream().distinct().collect(Collectors.toList());
    }

    private void generateCountMap(int[] nums) {
        for (int num : nums) {
            countOfNumber[num + pivot]++;
        }
    }

    private void findTripletsOfZeroSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isTripletOfZeroSum(nums[i], nums[j]))
                    addTriplet(nums[i], nums[j], -(nums[i] + nums[j]));
                }
            }
        }

    private void addTriplet(int first, int second, int third) {
        List<Integer> newTriplet = new ArrayList<>();

        newTriplet.add(first);
        newTriplet.add(second);
        newTriplet.add(third);

        triplets.add(newTriplet);
    }

    private boolean isTripletOfZeroSum(int first, int second) {
        int third = -(first + second);

        if(third > 5000 || third < -5000) return false;
        if(third < first || third < second) return false;

        countOfNumber[first + pivot]--;
        countOfNumber[second + pivot]--;
        countOfNumber[third + pivot]--;

        if (countOfNumber[first + pivot] < 0
                || countOfNumber[second + pivot] < 0
                || countOfNumber[third + pivot] < 0) {

            countOfNumber[first + pivot]++;
            countOfNumber[second + pivot]++;
            countOfNumber[third + pivot]++;
            return false;
        }

        countOfNumber[first + pivot]++;
        countOfNumber[second + pivot]++;
        countOfNumber[third + pivot]++;

        return true;
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

    //    private void generateCountMap(int[] nums) {
//        for (int num : nums) {
//            Integer count = countMap.getOrDefault(num, 0);
//            countMap.put(num, count + 1);
//        }
//    }

    private boolean isZeroOfSum(int[] triplet) {
        return Arrays.stream(triplet).sum() == 0;
    }
}
