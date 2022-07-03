//package com.company.kakao;
//
//import java.util.Arrays;
//
//public class HeavenOfWalker {
//
//    private int MOD = 20170805;
//
//    private int[][][] CACHE;
//    private int[][] MAP;
//
//    private int height;
//    private int width;
//
//    public int solution(int m, int n, int[][] cityMap) {
//        int answer = 0;
//
//        init(m, n, cityMap);
//
//        answer = dfs(0, 0, 0); //(조건을 만족하는 경로의 수)
//
//        return answer;
//    }
//
//
//    // y, x 에서 시작해서 도착점에 도달할 수 있는 경로의 수를 반환하는 함수
//    // prevDir 1 : 오른쪽 방향 , 2 : 아래쪽 방향
//    private int dfs(int x, int y, int prevDir) {
//        int result = 0;
//
//        if(CACHE[x][y][prevDir] > -1) return CACHE[x][y][prevDir];
//        if(x == m - 1 && y == n - 1) return 1; // 한 경로가 탐색이 됐다..
//
//        if (MAP[x][y] == 0 || (MAP[x][y] == 2 && prevDir != 2)) {
//            result = (result + dfs(x, y + 1, 1)) % MOD;
//        }
//
//        if (MAP[x][y] == 0 || (MAP[x][y] == 2 && prevDir != 1)) {
//            result = (result + dfs(x + 1, y, 2)) % MOD;
//        }
//
//        return CACHE[x][y][prevDir] = result;
//    }
//
//
////     prevDir => 1: 왼쪽, 2: 위
////    private int dfs(int y, int x, int prevDir) {
////        int result = 0;
////
////        if(y == height - 1 && x == width - 1) return 1;
////        if(CACHE[y][x][prevDir] > 0) return CACHE[y][x][prevDir];
////
////        if (MAP[y + 1][x] == 0 || (MAP[y + 1][x] == 2 && prevDir != 1)) {
////            result = (result + dfs(y + 1, x, 2)) % MOD;
////        }
////
////        if (MAP[y][x + 1] == 0 || (MAP[y][x + 1] == 2 && prevDir != 2)) {
////            result = (result + dfs(y, x + 1, 1)) % MOD;
////        }
////
////        return CACHE[y][x][prevDir] = result;
////    }
//
//    private void init(int m, int n, int[][] cityMap) {
//        height = m;
//        width = n;
//
//        MAP = new int[m + 1][n + 1];
//        CACHE = new int[m + 1][n + 1][3];
//
//        for (int i = 0; i <= height; i++) {
//            for (int j = 0; j <= width; j++) {
//                if (i < height && j < width) {
//                    MAP[i][j] = cityMap[i][j];
//
//                }
//                else {
//                    MAP[i][j] = -1;
//                }
//            }
//        }
//    }
//}
