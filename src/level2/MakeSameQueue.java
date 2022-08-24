package level2;

import java.util.*;

public class MakeSameQueue {

    public int solution(int[] queue1, int[] queue2) {
        SummaryQueue firstQueue  = new SummaryQueue(queue1);
        SummaryQueue secondQueue = new SummaryQueue(queue2);

        if(firstQueue.getSum() + secondQueue.getSum() % 2 == 1) return -1;
        return getMinimumOperationNumber(firstQueue, secondQueue, firstQueue.length() * 3);
    }

    private int getMinimumOperationNumber(SummaryQueue firstQueue, SummaryQueue secondQueue, int total) {

        int count = 0;

        while (count < total) {

            if (firstQueue.getSum() > secondQueue.getSum()) {
                secondQueue.push(firstQueue.pop());
                count++;
            }

            if (firstQueue.getSum() < secondQueue.getSum()) {
                firstQueue.push(secondQueue.pop());
                count++;
            }

            if (firstQueue.getSum().equals(secondQueue.getSum())) {
               break;
            }
        }

        return count >= total ? -1 : count;
    }

    static class SummaryQueue {

        private Long sum = 0L;
        private Queue<Long> queue = new LinkedList<>();

        public SummaryQueue(int[] inputArray) {
           for (int number : inputArray) {
                queue.add((long) number);
                sum += number;
            }
        }

        public int length() {
            return queue.size();
        }

        public void push(Long number) {
            queue.add(number);
            sum += number;
        }

        public Long pop() {
            Long number = queue.poll();
            sum -= number;
            return number;
        }

        public Long getSum() {
            return sum;
        }
    }
}
