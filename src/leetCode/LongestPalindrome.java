package leetCode;

public class LongestPalindrome {

    private int[][] isPalindrome = new int[1001][1001];
    
//    public String longestPalindrome(String str) {
//        init();
//        checkPalindrome(0, str.length() - 1, str);
//        return getLongestPalindrome(str);
//    }

    private void init() {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                isPalindrome[i][j] = -1;
            }
        }
    }

    private String getLongestPalindrome(String source) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < source.length(); i++) {
            for (int j = source.length() - 1; j >= i ; j--) {
                if (isPalindrome[i][j] == 1 && end - start < j - i) {
                    end = j;
                    start = i;
                }
            }
        }

        return source.substring(start, end + 1);
    }

//    private int checkPalindrome(int begin, int end, String source) {
//        if(begin >= end) return isPalindrome[begin][end] = 1;
//        if(isPalindrome[begin][end] > -1) return isPalindrome[begin][end];
//
//        checkPalindrome(begin + 1, end, source);
//        checkPalindrome(begin, end - 1, source);
//
//        if(source.charAt(begin) == source.charAt(end)) {
//            isPalindrome[begin][end] = checkPalindrome(begin + 1, end - 1, source);
//        }
//        else {
//            isPalindrome[begin][end] = 0;
//        }
//
//        return isPalindrome[begin][end];
//    }

    public String longestPalindrome(String source) {

        int begin = 0;
        int end   = 0;

        init();

        for (int i = 0; i < source.length(); i++) {
            for (int j = i; j < source.length(); j++) {
                if (checkPalindrome(i, j, source) == 1 && j - i > end - begin) {
                    begin = i;
                    end   = j;
                }
            }
        }


        return source.substring(begin, end + 1);
    }

    public int checkPalindrome(int begin, int end, String source) {
        if(begin >= end) {
            return isPalindrome[begin][end] = 1;
        }

        if(isPalindrome[begin][end] > -1) {
            return isPalindrome[begin][end];
        }

        if(source.charAt(begin) == source.charAt(end)) {
            return isPalindrome[begin][end]
                    = checkPalindrome(begin + 1, end - 1, source);
        }

        return isPalindrome[begin][end] = 0;
    }
}
