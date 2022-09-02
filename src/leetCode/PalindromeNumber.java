package leetCode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String integer = Integer.toString(x);
        return checkNumberWhetherPalindrome(0, integer.length() - 1, integer);
    }

    private boolean checkNumberWhetherPalindrome(int begin, int end, String integer) {
        if(begin >= end) {
            return true;
        }

        if (integer.charAt(begin) != integer.charAt(end)) {
            return false;
        }

        return checkNumberWhetherPalindrome(begin + 1, end - 1, integer);
    }
}
