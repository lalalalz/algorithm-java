package leetCode;

import java.util.Stack;

public class RemoveDuplicateLetters {

    private static final int ALPHABETS = 26;

    public String removeDuplicateLetters(String s) {
        return getDuplicatedStringOfSmallestOrder(s);
    }

    private String getDuplicatedStringOfSmallestOrder(String s) {
        int[] countOfAlphabet = countAlphabet(s);
        return generateDuplicatedString(s, countOfAlphabet);
    }

    private int[] countAlphabet(String s) {
        int[] result = new int[ALPHABETS];

        for (char ch : s.toCharArray()) {
            result[ch - 'a']++;
        }

        return result;
    }

    private String generateDuplicatedString(String s, int[] countOfAlphabet) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            countOfAlphabet[ch - 'a']--;

            if (!stack.contains(ch)) {
                removeAlphabetThatAppearAgain(countOfAlphabet, stack, ch);
                stack.push(ch);
            }
        }

        return stackToString(stack);
    }

    private void removeAlphabetThatAppearAgain(int[] countOfAlphabet, Stack<Character> stack, char ch) {
        while (!stack.empty() &&
                isTopAppearedAgain(countOfAlphabet, stack, ch)) {
            stack.pop();
        }
    }

    private boolean isTopAppearedAgain(int[] countOfAlphabet, Stack<Character> stack, char ch) {
        return ch < stack.peek() && countOfAlphabet[stack.peek() - 'a'] > 0;
    }

    private String stackToString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder
                .reverse()
                .toString();
    }
}