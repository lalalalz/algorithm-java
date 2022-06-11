package com.company.coupang2;

import java.util.Arrays;

public class Coupang2 {

    private final int MAX = 100000;
    private long[] result = new long[2];

    public long[] solution(Long n) {

        Arrays.fill(result, -1);

        for (long i = 2; i * i <= n; i++) {
            long j = n / i;
            if (i != j && isPrime(i) && isPrime(j)) {
                result[0] = i;
                result[1] = j;
                break;
            }
        }

        System.out.println(result[0] + ", " + result[1]);
        return result;
    }

    private boolean isPrime(long n) {
        for (long i = 2; i * i <= n ; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
