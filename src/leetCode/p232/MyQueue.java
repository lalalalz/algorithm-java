package leetCode.p232;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack = reverseStack(stack);
        stack.push(x);
    }

    private Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        return temp;
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("큐가 비어있습니다.");
        }

        stack = reverseStack(stack);
        return stack.pop();
    }

    public int peek() {
        stack = reverseStack(stack);
        Integer peek = stack.peek();
        stack = reverseStack(stack);
        return peek;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */