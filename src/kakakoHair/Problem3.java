package kakakoHair;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

    private static final int STONE = 1;
    private static final int ROBOT = 2;
    private static final int TARGET =3 ;
    private static final int MAX = 100 * 100;

    private int mapSizeY;
    private int mapSizeX;
    private int required;
    private int robotY;
    private int robotX;
    private int targetY;
    private int targetX;

    private int[][] cache = new int[MAX][MAX];
    private int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    private boolean[][] visited = new boolean[MAX][MAX];

    public int solution(int[][] board, int c) {
        init(board, c);
        return getMinimumEnergyByBfs(board, robotY, robotX);
    }

    private void init(int[][] board, int c) {
        required = c;
        mapSizeY = board.length;
        mapSizeX = board[0].length;

        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (board[i][j] == ROBOT) {
                    robotY = i;
                    robotX = j;
                }
                if (board[i][j] == TARGET) {
                    targetY = i;
                    targetX = j;
                }
                cache[i][j] = MAX;
            }
        }
    }

    private int getMinimumEnergyByBfs(int[][] board, int robotY, int robotX) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(robotY, robotX, 0));
        cache[robotY][robotX] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowY = now.y;
            int nowX = now.x;
            int nowEnergy = now.energy;

            if((nowY == targetY && nowX == targetX) || nowEnergy > cache[nowY][nowX]) continue;

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dir[i][0];
                int nextX = nowX + dir[i][1];

                if (nextY >= 0 && nextY < mapSizeY && nextX >= 0 && nextX < mapSizeX) {
                    if (board[nextY][nextX] == STONE && cache[nextY][nextX] > nowEnergy + required + 1) {
                        cache[nextY][nextX] = nowEnergy + required + 1;
                        queue.add(new Point(nextY, nextX, nowEnergy + required + 1));
                    }

                    if (board[nextY][nextX] != STONE && cache[nextY][nextX] > nowEnergy + 1) {
                        cache[nextY][nextX] = nowEnergy + 1;
                        queue.add(new Point(nextY, nextX, nowEnergy + 1));
                    }
                }
            }
        }

        return cache[targetY][targetX];
    }

    public static class Point {
        public int y;
        public int x;
        public int energy;

        public Point(int y, int x, int energy) {
            this.y = y;
            this.x = x;
            this.energy = energy;
        }
    }

    private int getMinimumEnergy(int[][]board, int y, int x) {
        int result = cache[y][x];

        if(result > -1) return result;
        if(y == targetY && x == targetX) return 0;

        result = MAX;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dir[i][0];
            int nextX = x + dir[i][1];

            if (nextY >= 0 && nextY < mapSizeY && nextX >= 0 && nextX < mapSizeX && !visited[nextY][nextX]) {
                if (board[nextY][nextX] == STONE) {
                    visited[nextY][nextX] = true;
                    result = Math.min(result, getMinimumEnergy(board, nextY, nextX) + 1 + required);
                    visited[nextY][nextX] = false;
                }
                else {
                    visited[nextY][nextX] = true;
                    result = Math.min(result, getMinimumEnergy(board, nextY, nextX) + 1);
                    visited[nextY][nextX] = false;
                }
            }
        }

        return result;
    }
}