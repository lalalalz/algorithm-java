package com.company;

import java.util.Stack;

public class Solution_CorrectBracket {

    public boolean solution(String s) {
        boolean answer = true;
        answer = checkBracket(s.toCharArray());
        return answer;
    }

    private boolean checkBracket(char[] s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s) {
            if(c == '(') stack.push(c);
            else if(!stack.empty() && stack.peek() == '(') stack.pop();
            else return false;
        }

        return stack.empty();
    }
}
