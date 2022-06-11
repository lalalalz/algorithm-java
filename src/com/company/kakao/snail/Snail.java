package com.company.kakao.snail;

public class Snail {

    public int[] solution(int n) {

        int[][] map = new int[n][n];
        int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};
        int[] answer = new int[(int)((n + 1) * ((double)n / 2))];

        int y = -1;
        int x = 0;
        int d = 0;
        int v = 1;

        for (int level = n; level >= 1; level--) {
            for (int i = 0; i < level; i++) {
                y = y + dir[d][0];
                x = x + dir[d][1];
                map[y][x] = v++;
            }
            d = (d + 1) % 3;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}
