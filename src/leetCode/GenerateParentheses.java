package leetCode;

import java.util.*;

public class GenerateParentheses {

    private Set<String> parenthesisSet = new HashSet<>();

    public List<String> generateParenthesis(int n) {
        findAllParenthesis(2 * n, "");
        return parenthesisSet.stream()
                .toList();
    }

    private void findAllParenthesis(int n, String str) {
        if (n == 0) {
            if (checkBracket(str.toCharArray())) {
                parenthesisSet.add(str);
            }
            return;
        }

        findAllParenthesis(n - 1, str + "(");
        findAllParenthesis(n - 1, str + ")");
    }

    private boolean checkBracket(char[] s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s) {
            if(c == '(') stack.push(c);
            else if(!stack.empty()) stack.pop();
            else return false;
        }

        return stack.empty();
    }
}
