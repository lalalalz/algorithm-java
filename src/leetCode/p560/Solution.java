package leetCode.p560;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixCountMap = new HashMap<>();

        prefixCountMap.put(0, 1);
        for (int num : nums) {
            prefixSum = num + prefixSum;
            answer += prefixCountMap.getOrDefault(prefixSum - k, 0);
            prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return answer;
    }
}
