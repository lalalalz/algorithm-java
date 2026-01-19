package leetCode.p125;

public class Solution {
    public boolean isPalindrome(String s) {
        return checkPalindrome(s
                .chars()
                .filter(character -> Character.isDigit(character) || Character.isAlphabetic(character))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .toLowerCase());
    }

    private boolean checkPalindrome(String lowerCase) {
        int left = 0;
        int right = lowerCase.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (lowerCase.charAt(left) == lowerCase.charAt(right)) {
                left++;
                right--;
            }
            else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
