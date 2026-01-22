package channelTalk;

import java.util.Arrays;

public class CircleQueue {

    private int[] queue;
    private int size;
    private int headIndex;
    private int tailIndex;

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);

        // 원소를 추가할 수 있다.
        circleQueue.push(1);
        circleQueue.push(2);
        circleQueue.push(3);
        circleQueue.push(4);
        circleQueue.push(5);

        // 용량을 넘어섰을 때 예외를 반환한다.
        try {
            circleQueue.push(6);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // 원소를 팝할 수 있다.
        System.out.println("pop, expected : 1," + circleQueue.pop());
        System.out.println("pop, expected : 2," + circleQueue.pop());
        System.out.println("pop, expected : 3," + circleQueue.pop());

        // 원소를 추가하고 하나를 배고 다시 추가할 수 있다. (순환구조 확인)
        circleQueue.push(1);
        circleQueue.push(2);
        circleQueue.push(3);
        circleQueue.pop();
        circleQueue.push(4);
    }

    public CircleQueue(int initCapacity) {
        queue = new int[initCapacity];
        size = 0;
        headIndex = 0;
        tailIndex = initCapacity - 1;
    }

    public void push(int input) {
        if (size >= queue.length) {
            int capacity = queue.length;
            queue = Arrays.copyOf(queue, 2 * capacity);
            headIndex = 0;
            tailIndex = capacity - 1;
        }

        if (tailIndex + 1 >= queue.length) {
            tailIndex = 0;
        }
        else {
            tailIndex++;
        }

        queue[tailIndex] = input;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("큐가 비어있습니다.");
        }

        int result = queue[headIndex];
        size--;

        if (headIndex + 1 >= queue.length) {
            headIndex = 0;
        }
        else {
            headIndex++;
        }

        return result;
    }

    public int size() {
        return size;
    }
}
