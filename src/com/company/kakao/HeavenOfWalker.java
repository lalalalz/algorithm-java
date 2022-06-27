package com.company.kakao;

import java.util.Arrays;

public class HeavenOfWalker {

    private int MOD = 20170805;

    private int[][][] CACHE;
    private int[][] MAP;

    private int height;
    private int width;

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        init(m, n, cityMap);

        answer = dfs(0, 0, 0);

        return answer;
    }

    // prevDir => 1: 왼쪽, 2: 위
    private int dfs(int y, int x, int prevDir) {
        int result = 0;

        if(y == height - 1 && x == width - 1) return 1;
        if(CACHE[y][x][prevDir] > 0) return CACHE[y][x][prevDir];

        if (MAP[y + 1][x] == 0 || (MAP[y + 1][x] == 2 && prevDir != 1)) {
            result = (result + dfs(y + 1, x, 2)) % MOD;
        }

        if (MAP[y][x + 1] == 0 || (MAP[y][x + 1] == 2 && prevDir != 2)) {
            result = (result + dfs(y, x + 1, 1)) % MOD;
        }

        return CACHE[y][x][prevDir] = result;
    }

    private void init(int m, int n, int[][] cityMap) {
        height = m;
        width = n;

        MAP = new int[m + 1][n + 1];
        CACHE = new int[m + 1][n + 1][3];

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if (i < height && j < width) {
                    MAP[i][j] = cityMap[i][j];
                }
                else {
                    MAP[i][j] = -1;
                }
            }
        }
    }
}
