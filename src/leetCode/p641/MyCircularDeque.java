package leetCode.p641;

class MyCircularDeque {

    private int front;
    private int rear;
    private int size;
    private final int capacity;
    private final int[] array;

    public MyCircularDeque(int k) {
        front = 0;
        rear = k - 1;
        size = 0;
        capacity = k;
        array = new int[k];
    }

    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }

        front = prev(front);
        array[front] = value;
        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }

        rear = next(rear);
        array[rear] = value;
        size++;

        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        front = next(front);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        rear = prev(rear);
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }

        return array[front];
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }

        return array[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    private int next(int index) {
        return (index + 1) % capacity;
    }

    private int prev(int index) {
        return (index - 1 + capacity) % capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
