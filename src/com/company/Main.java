package com.company;

import com.company.coupang1.Solution;

public class Main {

    public static void main(String[] args) {


//        int[][] input = {{1,3,1}, {3,5,0}, {5,4,0}, {2,5,0}};
        int[][] input = {{5,6,0}, {1,3,1}, {1,5,0}, {7,6,0}, {3,7,1}, {2,5,0}};

        // 1 : O
        // 2 : ?
        // 3 : O
        // 4 : ?
        // 5 : X
        // 6 : X
        // 7 : O

        Solution coupang1 = new Solution();
        String result = coupang1.solution(input, 7);

        System.out.println("result = " + result);
    }
}
