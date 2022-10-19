package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyPriorityQueue {


    public static void main(String[] args) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(new Element(1));
        priorityQueue.offer(new Element(5));
        priorityQueue.offer(new Element(1));
        priorityQueue.offer(new Element(2));
        priorityQueue.offer(new Element(3));

        while (!priorityQueue.isEmpty()) {
            Element poll = priorityQueue.poll();
            System.out.println("poll.value = " + poll.value);
        }
    }


    public static class Element implements Comparable<Element> {
        int value;

        public Element(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Element o) {
            return this.value > o.value ? 1 : -1;
        }
    }
}
