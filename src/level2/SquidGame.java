package level2;

public class SquidGame {

    private int[][] points;
    private int[][] cache = new int[10001][5];

    public int solution(int[][] land) {
        points = land;
        return getMaxPoint(-1, -1);
    }

    private int getMaxPoint(int y, int x) {
        if(y == points.length) return 0;

        int result = cache[y + 1][x + 1];
        if(result > 0) return result;

        for (int nextX = 0; nextX < points[0].length; nextX++) {
            if (nextX == x) continue;

            if (y >= 0) {
                result = Math.max(result, getMaxPoint(y + 1, nextX) + points[y][x]);
            }
            else  {
                result = Math.max(result, getMaxPoint(y + 1, nextX));
            }
        }

        return cache[y + 1][x + 1] = result;
    }
}
