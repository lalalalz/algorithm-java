package leetCode;

import java.util.*;

public class AssignCookies {

    public int findContentChildren(int[] greed, int[] cookieSize) {
        int result = 0;
        PriorityQueue<Integer> greedPQ = arrayToPriorityQueue(greed);
        PriorityQueue<Integer> cookiePQ = arrayToPriorityQueue(cookieSize);

        while (!greedPQ.isEmpty() && !cookiePQ.isEmpty()) {
            if (greedPQ.peek() <= cookiePQ.peek()) {
                result++;
                cookiePQ.poll();
            }
            greedPQ.poll();
        }

        return result;
    }

    private PriorityQueue<Integer> arrayToPriorityQueue(int[] target) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int element : target) {
            priorityQueue.add(element);
        }

        return priorityQueue;
    }

    private List<Integer> arrayToDescendingList(int[] target) {
        return Arrays.stream(target)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();
    }
}

