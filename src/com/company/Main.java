package com.company;

import com.company.coupang1.Coupang1;
import com.company.coupang2.Coupang2;
import com.company.coupang3.Coupang3;
import com.company.kakao.friendsBlock.FriendsBlock;
import com.company.kakao.snail.Snail;
import com.company.kakao.dividePowerGrid.Solution;

public class Main {

    public static void main(String[] args) {


//        int[][] input = {{1,3,1}, {3,5,0}, {5,4,0}, {2,5,0}};
////        int[][] input = {{5,6,0}, {1,3,1}, {1,5,0}, {7,6,0}, {3,7,1}, {2,5,0}};
//
//        // 1 : O
//        // 2 : ?
//        // 3 : O
//        // 4 : ?
//        // 5 : X
//        // 6 : X
//        // 7 : O
//
//        Coupang1 coupang1 = new Coupang1();
//        String result = coupang1.solution(input, 6);
//
//        System.out.println("result = " + result);
//
//        Coupang2 coupang2 = new Coupang2();
//        coupang2.solution(1000000000000L);


//        int[][] input = {{3, 2, 3, 2}, {2, 1, 1, 2}, {1, 1, 2, 1}, {4, 1, 1, 1}};
//        int[][] input = {{4, 2, 3, 2}, {2, 1, 2, 4}, {1, 2, 3, 1}, {4, 1, 4, 3}};
//        int[][] input = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
//
//        Coupang3 coupang3 = new Coupang3();
//        int answer = coupang3.solution(input);
//        System.out.println("answer = " + answer);

//
//        String[] input = {"TTTANT",
//                "RRFACC",
//                "RRRFCC",
//                "TRRRAA",
//                "TTMMMF",
//                "TMMTTJ"};
//        FriendsBlock friendsBlock = new FriendsBlock();
//        int answer = friendsBlock.solution(6, 6, input);
//        System.out.println("answer = " + answer);

//        Snail snail = new Snail();
//        snail.solution(5);

        int[][] input = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        Solution s = new Solution();
        int answer = s.solution(9, input);

        System.out.println("answer = " + answer);
    }
}
