package leetCode.p7;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
    }

    public int reverse(int x) {
        String reversed = new StringBuilder(String
                .valueOf(x)
                .replace("-", ""))
                .reverse()
                .toString();

        if (isOverflow(reversed)) {
            return 0;
        }

        return Integer.valueOf(getSign(x) + reversed);
    }

    String getSign(int x) {
        return x >= 0 ? "+" : "-";
    }

    boolean isOverflow(String number) {
        String max = String.valueOf(Integer.MAX_VALUE);

        if (number.length() > 10) return true;
        if (number.length() < 10) return false;

        return number.compareTo(max) > 0;
    }
}
