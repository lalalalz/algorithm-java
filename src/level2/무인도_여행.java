package level2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 3 ≤ maps의 길이 ≤ 100
 * 3 ≤ maps[i]의 길이 ≤ 100
 * maps[i]는 'X' 또는 1 과 9 사이의 자연수로 이루어진 문자열입니다.
 * 지도는 직사각형 형태입니다.
 */
public class 무인도_여행 {

    final boolean VISITED = true;
    final char WATER = 'X';
    boolean[][] visited = new boolean[101][101];
    int[][] director = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] solution(String[] maps) {
        List<Integer> foodInIsland = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != WATER && visited[i][j] != VISITED) {
                    foodInIsland.add(calcMaxDayInIsland(i, j, maps));
                }
            }
        }

        int[] answer = foodInIsland
                .stream()
                .sorted()
                .mapToInt(x -> x)
                .toArray();

        return answer.length > 0 ? answer : new int[]{-1};
    }

    int calcMaxDayInIsland(int i, int j, String[] maps) {
        int sumOfFoodQuantity = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(i, j));
        visited[i][j] = VISITED;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            sumOfFoodQuantity += Integer.parseInt(String.valueOf(maps[current.y].charAt(current.x)));

            for (int direction = 0; direction < 4; direction++) {
                int nextY = current.y + director[direction][0];
                int nextX = current.x + director[direction][1];

                if (canGoNextStep(nextY, nextX, maps)) {
                    visited[nextY][nextX] = VISITED;
                    queue.add(new Coordinate(nextY, nextX));
                }
            }
        }

        return sumOfFoodQuantity;
    }

    boolean canGoNextStep(int nextY, int nextX, String[] maps) {
        return isInMaps(nextY, nextX, maps) && isIsland(nextY, nextX, maps) && isFirstVisit(nextY, nextX);
    }

    boolean isFirstVisit(int nextY, int nextX) {
        return visited[nextY][nextX] != VISITED;
    }

    boolean isIsland(int nextY, int nextX, String[] maps) {
        return maps[nextY].charAt(nextX) != WATER;
    }

    boolean isInMaps(int nextY, int nextX, String[] maps) {
        return nextY >= 0 && nextX >= 0 &&
                nextY < maps.length && nextX < maps[0].length();
    }

    static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
