package leetCode;

public class LargestOddNumberInString {

    public String largestOddNumber(String num) {
        return getLargestOddNumber(num);
    }

    private String getLargestOddNumber(String num) {
        String result = "";

        for (int i = num.length() - 1; i >= 0; i--) {
            if (isOdd(num.charAt(i))) {
                result = num.substring(0, i + 1);
                break;
            }
        }

        return result;
    }

    private boolean isOdd(char c) {
        return (c - '0') % 2 > 0;
    }
}
