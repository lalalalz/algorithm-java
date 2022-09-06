package leetCode;

import java.util.EmptyStackException;
import java.util.Stack;

public class ValidParentheses {

    private static final char DUMMY = '0';

    public boolean isValid(String brackets) {
        return isValidBrackets(brackets);
    }

    private boolean isValidBrackets(String brackets) {
        int index = 0;
        Stack<Character> openBracketStore = new Stack<>();

            while (brackets.length() > index) {
            char bracket = brackets.charAt(index++);

            if (isOpenBracket(bracket)) {
                openBracketStore.push(bracket);
                continue;
            }

            if (isValidParentheses(openBracketStore, bracket)) {
                break;
            }
        }

        return openBracketStore.isEmpty();
    }

    private boolean isValidParentheses(Stack<Character> stack, char bracket) {
        try {
            Character pollBracket = stack.pop();

            if (!isSameType(pollBracket, bracket)) {
                stack.push(DUMMY);
                return true;
            }
        }
        catch (EmptyStackException e) {
            stack.push(DUMMY);
            return true;
        }

        return false;
    }

    private boolean isSameType(Character pollBracket, char bracket) {
        if(pollBracket == null) return false;

        if(pollBracket.charValue() == '(' && bracket == ')') return true;
        if(pollBracket.charValue() == '{' && bracket == '}') return true;
        if(pollBracket.charValue() == '[' && bracket == ']') return true;

        return false;
    }

    private boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }
}
