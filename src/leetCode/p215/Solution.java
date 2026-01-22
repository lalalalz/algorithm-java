package leetCode.p215;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest = " + kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, Comparator.reverseOrder());

        for (int num : nums) {
            priorityQueue.add(num);
        }

        for (int i = 0; i < k; i++) {
            //noinspection DataFlowIssue
            answer = priorityQueue.poll();
        }

        return answer;
    }
}
