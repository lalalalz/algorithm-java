package com.company.coupang1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[] stockStatus = new int[10001];
    int[][] deliveryStatus = new int[10001][10001];
    Queue<Integer> queue = new LinkedList<>();

    private final int NONE = 0;  // 배송정보 없음
    private final int NODELIVERY = 1; // 배송 안됨
    private final int DELIVERY = 2; // 배송 됨

    private final int UNDETERMINED = 0; // 재고 모름
    private final int INSTOCK = 1;  // 재고 있음
    private final int OUTOFSTOCK = 2; // 재고 없음

    public String solution(int[][] inputs, int n) {

        for (int[] input : inputs) {
            int firstNode = input[0];
            int secondNode = input[1];
            int deliveryCode = input[2] + 1;

            deliveryStatus[firstNode][secondNode] = deliveryCode;
            deliveryStatus[secondNode][firstNode] = deliveryCode;

            if (deliveryCode == DELIVERY) {
                stockStatus[firstNode] = INSTOCK;
                stockStatus[secondNode] = INSTOCK;
                queue.add(firstNode);
                queue.add(secondNode);
            }
        }

        setAnotherNode(n);
        return generateResult(stockStatus, n);
    }

    private String generateResult(int[] result, int n) {
        String generatedResult = "";

        for (int node = 1; node <= n; node++) {
            if(result[node] == INSTOCK) generatedResult += "O";
            if(result[node] == OUTOFSTOCK) generatedResult += "X";
            if(result[node] == UNDETERMINED) generatedResult += "?";
        }

        return generatedResult;
    }

    private void setAnotherNode(int n) {
        while (!queue.isEmpty()) {
            Integer peekNode = queue.peek();
            queue.poll();

            for (int anotherNode = 1; anotherNode < n; anotherNode++) {
                int deliveryCode = deliveryStatus[peekNode][anotherNode];

                if (deliveryCode != NONE && stockStatus[anotherNode] == UNDETERMINED) {
                    stockStatus[anotherNode] = (deliveryCode == DELIVERY ? INSTOCK : OUTOFSTOCK);

                    if(stockStatus[anotherNode] == INSTOCK){
                        queue.add(anotherNode);
                    }
                }
            }
        }
    }
}
