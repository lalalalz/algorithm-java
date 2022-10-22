package leetCode;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        return isValidPalindrome(0, s.length() - 1, s.toCharArray());
    }

    private boolean isValidPalindrome(int begin, int end, char[] str) {
        if (begin >= end) {
            return true;
        }

        if (str[begin] == str[end]) {
            return isValidPalindrome(begin + 1, end - 1, str);
        }
    }
}
