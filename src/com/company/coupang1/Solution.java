package com.company.coupang1;

import java.util.Arrays;

public class Solution {

    public void solution(int[][] inputs, int n) {

        // 1 : 재고있음
        // 2 : 재고없음
        // 3 : 모름
        int[] result = new int[n + 1];

        Arrays.fill(result, 3);

        for (int[] input : inputs) {

            int firstProduct = input[0];
            int secondProduct = input[1];
            int deliveryStatus = input[2];

            // 배송하지 않음
            if (deliveryStatus == 0) {
                if (result[firstProduct] == 3) {
                    result[firstProduct] = result[secondProduct] == 1 ? 2 : 3;
                }
                else if (result[secondProduct] == 3) {
                    result[secondProduct] = result[firstProduct] == 1 ? 2 : 3;
                }
                else {
                    result[firstProduct] = 3;
                    result[secondProduct] = 3;
                }
            }

            // 배송함
            else {
                result[firstProduct] = 1;
                result[secondProduct] = 1;
            }
        }

        for (int i = 1; i < result.length; ++i) {
            System.out.println(i + ": " + result[i]);
        }
    }
}
