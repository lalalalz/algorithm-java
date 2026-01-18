package leetCode.p3084;

public class Solution {

    private String input;
    private int[] prefixSum = new int[100_001];

    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = solution.countSubstrings("zzz", 'z');
        System.out.println("l = " + l);
    }

    public long countSubstrings(String s, char c) {
        input = s;
        calcPrefixSum(s, c);
        return func(0, c);
    }

    private void calcPrefixSum(String s, char c) {
        for (int i = s.length() - 1; i >= 0; --i) {
            prefixSum[i] = s.charAt(i) == c
                    ? prefixSum[i + 1] + 1
                    : prefixSum[i + 1];
        }
    }

    private long func(int start, char c) {
        if (start >= input.length()) {
            return 0;
        }

        if (input.charAt(start) != c) {
            return func(start + 1, c);
        }

        return func(start + 1, c) + prefixSum[start];
    }
}
