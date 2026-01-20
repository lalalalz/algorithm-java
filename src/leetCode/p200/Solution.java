package leetCode.p200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited = new boolean[300][300];

    public int numIslands(char[][] grid) {
        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '0') {
                    answer++;
                    bfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();

        visited[i][j] = true;
        queue.add(new Pair(i, j));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextY = current.y + direction[dir][0];
                int nextX = current.x + direction[dir][1];

                if (nextY >= 0
                        && nextX >= 0
                        && nextY < grid.length
                        && nextX < grid[0].length
                        && grid[nextY][nextX] == '0'
                        && !visited[nextY][nextX]
                ) {
                    visited[nextY][nextX] = true;
                    queue.add(new Pair(nextY, nextX));
                }
            }
        }
    }

    private record Pair(int y, int x) {
    }
}
