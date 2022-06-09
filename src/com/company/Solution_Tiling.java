package com.company;

import java.util.Arrays;

public class Solution_Tiling {

    private final int MAX = 1_000_000_007;
    private final int[] cache = new int[60001];

    public int solution(int n) {
        int answer = 0;
        
        cacheInit(n);
        answer = tiling(n);
        
        return answer;
    }

    private void cacheInit(int n) {
        Arrays.fill(cache, -1);
    }

    private int tiling(int n) {
        if(n <  0) return 0;
        if(n == 0) return 1;
        if(cache[n] > -1) return cache[n];

        return cache[n] = (tiling(n - 1) + tiling(n - 2)) % MAX;
    }
}
