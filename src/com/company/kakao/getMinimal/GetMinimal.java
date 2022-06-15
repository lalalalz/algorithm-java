package com.company.kakao.getMinimal;

import java.util.Arrays;

public class GetMinimal {

    public int solution(int []a, int []b)
    {
        int sum = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            for (int j = b.length - 1; j >= 0; j--) {
                sum += a[i] * b[j];
            }
        }

        return sum;
    }
}
