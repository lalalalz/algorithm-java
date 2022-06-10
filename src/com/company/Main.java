package com.company;

import com.company.coupang1.Solution;

public class Main {

    public static void main(String[] args) {


//        int[][] input = {{1,3,1}, {3,5,0}, {5,4,0}, {2,5,0}};
        int[][] input = {{5,6,0}, {1,3,1}, {1,5,0}, {7,6,0}, {3,7,1}, {2,5,0}};

        Solution coupang1 = new Solution();
        coupang1.solution(input, 7);
    }
}
