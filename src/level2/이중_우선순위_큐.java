package level2;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 이중_우선순위_큐 {
    public int[] solution(String[] operations) {
        TwoWayPriorityQueue twoWayPriorityQueue = new TwoWayPriorityQueue();

        for (String operation : operations) {
            twoWayPriorityQueue.doRun(operation);
        }

        return new int[]{twoWayPriorityQueue.getMax(), twoWayPriorityQueue.getMin()};
    }

    public enum Operator {
        INPUT, OUTPUT_MAX, OUTPUT_MIN;
    }

    public static class TwoWayPriorityQueue {
        public static final String INPUT_OPERATOR = "I";
        public static final String OUTPUT_MAX_OPERATOR = "1";
        public static final boolean INPUT = true;
        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());

        public void doRun(String operation) {
            Operator operate = parseOperate(operation);

            if (operate == Operator.INPUT) {
                int operand = parseOperand(operation);
                maxQueue.add(operand);
                minQueue.add(operand);
            }
            if (operate == Operator.OUTPUT_MAX) {
                Integer max = maxQueue.poll();
                minQueue.remove(max);
            }
            if (operate == Operator.OUTPUT_MIN) {
                Integer min = minQueue.poll();
                maxQueue.remove(min);
            }
        }

        public int getMax() {
            return maxQueue.isEmpty() ? 0 : maxQueue.peek();
        }

        public int getMin() {
            return minQueue.isEmpty() ? 0 : minQueue.peek();
        }

        private int parseOperand(String operation) {
            return Integer.parseInt(operation.split(" ")[1]);
        }

        private Operator parseOperate(String operation) {
            if (INPUT_OPERATOR.equals(operation.split(" ")[0])) {
                return Operator.INPUT;
            }
            else if(OUTPUT_MAX_OPERATOR.equals(operation.split(" ")[1])) {
                return Operator.OUTPUT_MAX;
            }
            else {
                return Operator.OUTPUT_MIN;
            }
        }
    }

    public static class TwoWayPriorityQueueByDeque {
        private Deque<Integer> deque = new ArrayDeque<>();

        public void doRun(String operation) {
            String[] splitOperation = operation.split(" ");
            String operator = splitOperation[0];
            int operand = Integer.parseInt(splitOperation[1]);

            if ("|".equals(operator)) {
                deque.addFirst(operand);
            }
            else if(!deque.isEmpty()) {
                if (operand > 0) {
                    deque.removeFirst();
                }
                else {
                    deque.removeLast();
                }
            }

            deque = deque
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toCollection(ArrayDeque::new));
        }

        public int getMax() {
            if (deque.isEmpty()) {
                return 0;
            }

            return deque.getFirst();
        }

        public int getMin() {
            if (deque.isEmpty()) {
                return 0;
            }

            return deque.getLast();
        }
    }
}
