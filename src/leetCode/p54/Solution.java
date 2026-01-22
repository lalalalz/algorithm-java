package leetCode.p54;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] visited = new boolean[100][100];

    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 0;
        List<Integer> answer = new ArrayList<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty() && answer.size() < matrix.length * matrix[0].length) {
            Pair current = queue.poll();

            // 방문 처리
            if (!visited[current.y][current.x]) {
                answer.add(matrix[current.y][current.x]);
                visited[current.y][current.x] = true;
            }

            // 다음 방문 지점 계산하기
            int nextY = current.y + dir[direction % 4][0];
            int nextX = current.x + dir[direction % 4][1];

            // 매트릭스를 벗어나면 방향을 바꿔서 진행하도록 처리
            if (nextY < 0 || nextX < 0 || nextY >= matrix.length || nextX >= matrix[0].length || visited[nextY][nextX]) {
                queue.add(current);
                direction++;
            }
            else {
                queue.add(new Pair(nextY, nextX));
            }
        }

        return answer;
    }

    private record Pair(int y, int x) {
    }
}
