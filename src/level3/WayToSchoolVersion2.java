package level3;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class WayToSchoolVersion2 {

    private static final int PUDDLE = 1;
    private static final int NON_PUDDLE  = 0;
    private static final int MAX_STEP = 101 * 101;

    private int[][] dir = {{0, 1}, {1, 0}};
    private int[][] puddlesPosition = new int[101][101];

    public int solution(int m, int n, int[][] puddles) {
        setPuddlesPosition(puddles);

        int minimumStepsToSchool = getMinimumStepsToSchool(m, n);
        return getNumberOfPathOfMinimumSteps(0, 0, m , n, 0, minimumStepsToSchool);
    }

    private int getNumberOfPathOfMinimumSteps(int y, int x, int width, int height, int step, int minimumStepsToSchool) {
        int result = 0;

        if (y == height - 1 && x == width - 1 && step == minimumStepsToSchool) {
            return 1;
        }

        if (y + 1 < height && puddlesPosition[y + 1][x] == NON_PUDDLE) {
            result += getNumberOfPathOfMinimumSteps(y + 1, x, width, height, step + 1, minimumStepsToSchool);
        }

        if (x + 1 < width && puddlesPosition[y][x + 1] == NON_PUDDLE) {
            result += getNumberOfPathOfMinimumSteps(y, x + 1, width, height, step + 1, minimumStepsToSchool);
        }

        return result;
    }

    private void setPuddlesPosition(int[][] puddles) {
        for (int i = 0; i < puddles.length; i++) {
            int puddlesY = puddles[i][1];
            int puddlesX = puddles[i][0];
            puddlesPosition[puddlesY - 1][puddlesX - 1] = PUDDLE;
        }
    }

    // 다익스트라
    private int getMinimumStepsToSchool(int width, int height) {
        int[][] minimumStepsToSchool = new int[height][width];

        PriorityQueue<Position> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Position(0, 0, 0));

        setMinimumStepsToSchool(width, height, minimumStepsToSchool);
        minimumStepsToSchool[0][0] = 0;

        while (!priorityQueue.isEmpty()) {
            Position now = priorityQueue.poll();
            int nowY = now.y;
            int nowX = now.x;
            int nowStep = now.step;

            if (nowY == height - 1 && nowX == width - 1
                    && minimumStepsToSchool[nowY][nowX] < nowStep) {
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int nextY = nowY + dir[i][0];
                int nextX = nowX + dir[i][1];

                if (nextY < height && nextX < width
                        && puddlesPosition[nextY][nextX] == NON_PUDDLE
                        && minimumStepsToSchool[nextY][nextX] > nowStep + 1) {

                    minimumStepsToSchool[nextY][nextX] = nowStep + 1;
                    priorityQueue.add(new Position(nextY, nextX, nowStep + 1));
                }
            }
        }

        return minimumStepsToSchool[height - 1][width - 1];
    }

    private void setMinimumStepsToSchool(int width, int height, int[][] minimumStepsToSchool) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                minimumStepsToSchool[i][j] = MAX_STEP;
            }
        }
    }

    public static class Position implements Comparable {
        int x;
        int y;
        int step;

        public Position(int y, int x, int step) {
            this.y = y;
            this.x = x;
            this.step = step;
        }

        @Override
        public int compareTo(Object o) {
            Position another = (Position) o;
            if(this.step <  another.step) return 1;
            if(this.step == another.step) return 0;
            return -1;
        }
    }
}
