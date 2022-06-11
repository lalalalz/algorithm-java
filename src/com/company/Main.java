package com.company;

import com.company.coupang3.Coupang3;

public class Main {

    public static void main(String[] args) {


////        int[][] input = {{1,3,1}, {3,5,0}, {5,4,0}, {2,5,0}};
//        int[][] input = {{5,6,0}, {1,3,1}, {1,5,0}, {7,6,0}, {3,7,1}, {2,5,0}};
//
//        // 1 : O
//        // 2 : ?
//        // 3 : O
//        // 4 : ?
//        // 5 : X
//        // 6 : X
//        // 7 : O
//
//        Solution coupang1 = new Solution();
//        String result = coupang1.solution(input, 7);
//
//        System.out.println("result = " + result);

//
//        Solution coupang2 = new Solution();
//        coupang2.solution(10L);


//        int[][] input = {{3, 2, 3, 2}, {2, 1, 1, 2}, {1, 1, 2, 1}, {4, 1, 1, 1}};
        int[][] input = {{4, 2, 3, 2}, {2, 1, 2, 4}, {1, 2, 3, 1}, {4, 1, 4, 3}};

        Coupang3 coupang3 = new Coupang3();
        int answer = coupang3.solution(input);
        System.out.println("answer = " + answer);
    }
}
