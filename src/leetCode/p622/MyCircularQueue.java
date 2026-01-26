package leetCode.p622;

class MyCircularQueue {

    private int front;
    private int rear;
    private int size;
    private final int capacity;
    private final int[] queue;

    public MyCircularQueue(int k) {
        front = 0;
        rear = -1;
        capacity = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == capacity) {
            return false;
        }

        rear = next(rear);
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }

        front = next(front);
        size--;
        return true;
    }

    public int Front() {
        return queue[front];
    }

    public int Rear() {
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int next(int index) {
        return (index + 1) % capacity;
    }
}