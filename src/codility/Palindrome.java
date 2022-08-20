package codility;

public class Palindrome {

    private String largestPalindrome = "0";
    private int[] canUse = new int[10];
    private boolean[] isVisited = new boolean[100001];

    public String solution(String S) {
        setCanUse(S);
        getLargestPalindrome("", S);
        return largestPalindrome;
    }

    private void setCanUse(String s) {
        for (int i = 0; i < s.length(); i++) {
            int number = s.charAt(i) - '0';
            canUse[number]++;
        }
    }

    private void getLargestPalindrome(String palindrome, String s) {

        if (!palindrome.equals(s) && isPalindrome(palindrome)) {

            if (largestPalindrome.isEmpty()) {
                largestPalindrome = palindrome;
            }

            else if (!palindrome.isEmpty()) {
                int largest = Integer.valueOf(largestPalindrome);
                int p = Integer.valueOf(palindrome);
                largestPalindrome = largest > p ? largestPalindrome : palindrome;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (canUse[i] > 0) {
                canUse[i]--;
                String addNumber = String.valueOf(i);
                getLargestPalindrome(palindrome + addNumber, s);
                canUse[i]++;
            }
        }
    }

    private boolean isPalindrome(String palindromeString) {
        int start = 0;
        int end = palindromeString.length() - 1;

        while (start <= end) {
            if (palindromeString.charAt(start) != palindromeString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
