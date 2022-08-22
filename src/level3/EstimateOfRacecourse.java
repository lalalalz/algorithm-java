package level3;

import java.util.Arrays;

public class EstimateOfRacecourse {

    private int size;
    private int[][] map;
    private int[][] cache = new int[26][26];

    private int minimumCost;
    private int MAX = 0xffffff;
    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우, 하, 좌, 상

    public int solution(int[][] board) {
        init(board);
        getMinimumCost(0, 0, 0,4);
        return minimumCost;
    }

    private void init(int[][] board) {
        map  = board;
        size = board.length;
        minimumCost = MAX;

        for (int i = 0; i < size; i++) {
            Arrays.fill(cache[i], MAX);
        }
    }

    private void getMinimumCost(int y, int x, int cost, int prevDir) {
        if(y == size - 1 && x == size - 1) {
            minimumCost = Math.min(minimumCost, cost);
            return;
        }
        if (minimumCost < cost || cache[y][x] < cost) {
            return;
        }

        cache[y][x] = Math.min(cache[y][x], cost);
        for (int d = 0; d < 4; d++) {
            int newY = y + dir[d][0];
            int newX = x + dir[d][1];

            if (newY >= 0 && newX >= 0 && newY < size
                    && newX < size && map[newY][newX] == 0) {

                map[newY][newX] = 1;
                getMinimumCost(newY, newX, cost + calcCost(d, prevDir), d);
                map[newY][newX] = 0;
            }
        }
    }

    private int calcCost(int d, int prevDir) {
        if(prevDir == 4) return 100;
        if(prevDir == d) return 100;
        return 600;
    }
}
