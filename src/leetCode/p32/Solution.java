package leetCode.p32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class Solution {

    public int longestValidParentheses(String s) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    answer = Math.max(answer, i - stack.peek());
                }
            }
        }

        return answer;
    }

    public int longestValidParenthesesTwoPass(String s) {
        int answer = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(') {
                left++;
            }
            else {
                right++;
            }

            if (left == right) {
                answer = Math.max(answer, 2 * right);
            }
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char character = s.charAt(i);
            if (character == '(') {
                left++;
            }
            else {
                right++;
            }

            if (left == right) {
                answer = Math.max(answer, 2 * left);
            }
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return answer;
    }
}
