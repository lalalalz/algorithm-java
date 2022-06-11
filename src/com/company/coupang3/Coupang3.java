package com.company.coupang3;

import java.util.Arrays;

public class Coupang3 {

    private int height;
    private int width;
    private int[][] map;
    private boolean[][] visited;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(int[][] board) {
        int answer = 0;

        map = board;
        width = board[0].length;
        height = board.length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited = new boolean[height][width];
                answer = Math.max(answer, dfs(i, j, map[i][j]));
            }
        }

        return answer > 0 ? answer : -1;
    }

    private int dfs(int y, int x, int number) {
        int result = 0;

        for (int d = 0; d < 4; d++) {
            int newY = y + dir[d][0];
            int newX = x + dir[d][1];

            if (newY >= 0 && newX >= 0 && newY < height && newX < width
            && !visited[newY][newX] && map[newY][newX] == number) {

                visited[newY][newX] = true;
                result = Math.max(result, dfs(newY, newX, number) + 1);
                visited[newY][newX] = false;
            }
        }

        return result;
    }
}
