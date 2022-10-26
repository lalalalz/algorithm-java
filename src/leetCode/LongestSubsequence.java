package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubsequence {

    public int[] answerQueries(int[] nums, int[] queries) {
        List<Integer> answers = new ArrayList<>();

        int[] accumulativeSum = generateAccumulativeSum(nums);
        for (int query : queries) {
            int size = getSizeOfSubsequenceThatSumLessThanOrEqual(accumulativeSum, query);
            answers.add(size);
        }

        return answers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int[] generateAccumulativeSum(int[] nums) {
        int[] result = new int[nums.length];

        Arrays.sort(nums);

        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] += result[i - 1] + nums[i];
        }

        return result;
    }

    private int getSizeOfSubsequenceThatSumLessThanOrEqual(int[] accumulativeSum, int query) {
        int mid = 0;
        int begin = 0;
        int end = accumulativeSum.length - 1;

        while (begin <= end) {
            mid = (begin + end) / 2;

            if (accumulativeSum[mid] - query > 0) {
                end = mid - 1;
            }

            if (accumulativeSum[mid] - query < 0) {
                begin = mid + 1;
            }

            if (accumulativeSum[mid] - query == 0) {
                break;
            }
        }

        if(accumulativeSum[mid] <= query) return mid + 1;
        return mid;
    }
}
