package leetCode.p2466;

import java.util.*;

public class Solution {

    private Set<String> goodStrings = new HashSet<>();
    private Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countGoodStrings(3, 3, 1, 1);
        System.out.println("i = " + i);
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        int MOD = 1_000_000_007;
        int result = 0;

        for (int length = 1; length <= high; length++) {
            int count = 0;

            // zero개의 '0'을 추가하는 경우
            if (length >= zero && dp.containsKey(length - zero)) {
                count = (count + dp.get(length - zero)) % MOD;
            }

            // one개의 '1'을 추가하는 경우
            if (length >= one && dp.containsKey(length - one)) {
                count = (count + dp.get(length - one)) % MOD;
            }

            if (count > 0) {
                dp.put(length, count);

                // low와 high 사이의 길이면 결과에 추가
                if (length >= low) {
                    result = (result + count) % MOD;
                }
            }
        }

        return result;
    }

}
