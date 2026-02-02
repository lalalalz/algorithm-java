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
        size = 0;
        capacity = k;
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = nextIndex(rear);
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = nextIndex(front);
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private int nextIndex(int index) {
        return (index + 1) % capacity;
    }
}
