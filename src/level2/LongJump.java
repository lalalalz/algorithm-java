package level2;

import java.util.Arrays;

public class LongJump {

    private final int mod = 1234567;
    private int[] cache = new int[5001];

    public long solution(int n) {
        Arrays.fill(cache, -1);
        return longJump(n);
    }

    private int longJump(int n) {
        if(n <  0) return 0;
        if(n == 0) return 1;

        if(cache[n] > -1) return cache[n];
        return cache[n] = (longJump(n - 1) + longJump(n - 2)) % mod;
    }
}
