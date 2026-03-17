package level1.나선형;

public class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int number = 1;
        int currentY = 0;
        int currentX = 0;

        int direction = 0;
        int[][] directionArray = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (number <= n * n) {
            answer[currentY][currentX] = number++;
            direction = updateDirection(n, currentY, directionArray, currentX, answer, direction);
            currentY += directionArray[direction][0];
            currentX += directionArray[direction][1];
        }

        return answer;
    }

    private static int updateDirection(int n, int y, int[][] directionArray, int x, int[][] answer, int direction) {
        int nextY = y + directionArray[y][0];
        int nextX = x + directionArray[y][1];

        if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n || answer[nextY][nextX] != 0) {
            direction = (direction + 1) % 4;
        }

        return direction;
    }
}
