package leetCode.p225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다!");
        }

        int returnValue;
        Queue<Integer> newQueue = new LinkedList<>();

        while (true) {
            int polled = queue.poll();

            if (queue.isEmpty()) {
                returnValue = polled;
                break;
            }
            else {
                newQueue.add(polled);
            }
        }

        queue = newQueue;
        return returnValue;
    }

    public int top() {
        int returnValue = pop();
        push(returnValue);
        return returnValue;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */