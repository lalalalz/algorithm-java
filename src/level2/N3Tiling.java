package level2;

import java.util.Arrays;

public class N3Tiling {

    private final int mod = 1000000007;
    private long[] cache = new long[5001];

    public int solution(int n) {
        Arrays.fill(cache, -1);
        return (int)tiling(n);
    }


    private long tiling(int n) {
        if(n <  0) return 0;
        if(n == 0) return 1;
        if(n == 1) return 0;
        if(n == 2) return 3;

        if(cache[n] > -1) return cache[n];

        cache[n] = 3 * tiling(n - 2);
        for (int i = 4; i <= n; i+=2) {
            cache[n] += 2 * tiling(n - i);
        }

        return cache[n] % mod;
    }
//
//    public int solution(int n) {
//        cache[0] = 1;
//        cache[2] = 3;
//
//        for (int i = 4; i <= n; i++) {
//            cache[i] = 3 * cache[i - 2];
//
//            for (int j = 4; j <= i; j+=2) {
//                if (j >= 0) {
//                    cache[i] += 2 * cache[i - j];
//                }
//            }
//
//            cache[i] = cache[i] % mod;
//        }
//
//        return (int) cache[n];
//    }
}
