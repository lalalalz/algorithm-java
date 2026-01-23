package leetCode.p1539;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int answer = 0;
        int exclusiveNumberCount = 0;
        Set<Integer> inclusive = new HashSet<>();

        for (int number : arr) {
            inclusive.add(number);
        }

        for (int i = 1; ; i++) {
            if (!inclusive.contains(i)) {
                exclusiveNumberCount++;
            }
            if (exclusiveNumberCount == k) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
