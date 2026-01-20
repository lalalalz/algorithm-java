package leetCode.p994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[][] cost = new int[10][10];
    private int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    cost[i][j] = 0;
                }
                else {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    bfs(i, j, grid);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                else if (grid[i][j] == 1 && cost[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
                else {
                    answer = Math.max(answer, cost[i][j]);
                }
            }
        }

        return answer;
    }

    private void bfs(int i, int j, int[][] grid) {
        int maxCost = 0;
        Queue<Cell> queue = new LinkedList<>();

        cost[i][j] = 0;
        queue.add(new Cell(i, j));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextY = current.y + dir[k][0];
                int nextX = current.x + dir[k][1];

                if (isValidPosition(nextY, nextX, grid) && canVisit(nextY, nextX, current, grid)) {
                    cost[nextY][nextX] = cost[current.y][current.x] + 1;
                    queue.add(new Cell(nextY, nextX));
                }
            }
        }
    }

    private boolean canVisit(int nextY, int nextX, Cell current, int[][] grid) {
        return cost[nextY][nextX] > cost[current.y][current.x] + 1 && grid[nextY][nextX] == 1;
    }

    private static boolean isValidPosition(int nextY, int nextX, int[][] grid) {
        return nextY >= 0 && nextX >= 0 && nextY < grid.length && nextX < grid[0].length;
    }

    private record Cell(int y, int x) {
    }
}
