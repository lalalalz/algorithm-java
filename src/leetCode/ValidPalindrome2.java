package leetCode;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        return isValidPalindrome(0, s.length() - 1, 1, s.toCharArray());
    }

    private boolean isValidPalindrome(int begin, int end, int chanceOfDelete, char[] str) {
        if (begin >= end) {
            return true;
        }

        if (str[begin] == str[end]) {
            return isValidPalindrome(begin + 1, end - 1, chanceOfDelete, str);
        }

        if (chanceOfDelete > 0) {
            return isValidPalindrome(begin + 1, end, chanceOfDelete - 1, str)
                    || isValidPalindrome(begin, end - 1, chanceOfDelete - 1, str);
        }

        return false;
    }
}
