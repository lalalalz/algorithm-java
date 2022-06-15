package com.company.kakao;

import java.util.Arrays;

public class MakingPrimeNumber {

    private int[] numbers;
    private boolean[] isPrimeNumber = new boolean[1501];

    public int solution(int[] nums) {
        return getPrimeNumberCount(nums);
    }

    private int getPrimeNumberCount(int[] nums) {
        numbers = nums;
        getPrimeNumbers();
        return getCount(0, 0, 0);
    }

    private void getPrimeNumbers() {
        Arrays.fill(isPrimeNumber, true);

        for (int i = 2; i <= 1500; i++) {
            if(!isPrimeNumber[i]) continue;

            for (int j = i + i; j <= 1500; j+=i) {
                isPrimeNumber[j] = false;
            }
        }
    }

    private int getCount(int prevIndex, int count, int sum) {
        int result = 0;

        if(count >= 2 && isPrimeNumber[sum]) return 1;

        for (int i = prevIndex + 1; i < numbers.length; i++) {
            result += getCount(i, count + 1, sum + numbers[i]);
        }

        return result;
    }
}
