package leetCode.p347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> kMostFrequentEntry = frequency
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .toList()
                .reversed()
                .subList(0, k);

        return kMostFrequentEntry
                .stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
