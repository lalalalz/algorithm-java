package level3;

import java.util.LinkedList;
import java.util.Queue;

public class GetItems {

    private final int LEFT = 0;
    private final int RIGHT = 1;
    private final int UP = 2;
    private final int DOWN = 3;

    private final int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int[][] map = new int[501][501];

    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        drawRectangles(rectangles);
        return bfs(characterY, characterX, itemY, itemX);
    }

    private void drawRectangles(int[][] rectangles) {
        for (int[] rectangle : rectangles) {
            drawRectangleLine(rectangle);
        }

        for (int[] rectangle : rectangles) {
            drawRectangleArea(rectangle);
        }
    }

    private void drawRectangleArea(int[] rectangle) {
        int leftX  = rectangle[0] * 10, leftY  = rectangle[1] * 10;
        int rightX = rectangle[2] * 10, rightY = rectangle[3] * 10;

        for (int i = 1; i <= Math.abs(leftY - rightY) - 1; i++) {
            drawLine(leftY + i, leftX + 1, RIGHT, Math.abs(leftX - rightX) - 2, 0);
        }
    }

    private void drawRectangleLine(int[] rectangle) {
        int leftX  = rectangle[0] * 10, leftY  = rectangle[1] * 10;
        int rightX = rectangle[2] * 10, rightY = rectangle[3] * 10;

        drawLine(leftY, leftX, DOWN, Math.abs(leftY - rightY), 1);
        drawLine(rightY, rightX, UP, Math.abs(leftY - rightY), 1);
        drawLine(leftY, leftX, RIGHT, Math.abs(leftX - rightX), 1);
        drawLine(rightY, rightX, LEFT, Math.abs(leftX - rightX), 1);
    }

    private void drawLine(int y, int x, int dir, int length, int val) {
        int nowY = y, nowX = x;

        for (int i = 0; i <= length; i++) {
            map[nowY][nowX] = val;
            nowY += direction[dir][0];
            nowX += direction[dir][1];
        }
    }

    private int bfs(int characterY, int characterX, int itemY, int itemX) {
        int result = 0;
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(characterY * 10, characterX * 10));

        while (!queue.isEmpty()) {
            Coordinates now = queue.poll();
            int nowY = now.y;
            int nowX = now.x;

            if (nowY == itemY * 10 && nowX == itemX * 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + direction[i][0];
                int nextX = nowX + direction[i][1];

                if (nextY >= 0 && nextX >= 0 && nextY < 501 && nextX < 501 && map[nextY][nextX] == 1) {
                    map[nextY][nextX] = map[nowY][nowX] + 1;
                    queue.add(new Coordinates(nextY, nextX));
                }
            }
        }

        return map[itemY * 10][itemX * 10] / 10;
    }

    public static class Coordinates {
        private int x;
        private int y;

        Coordinates(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
