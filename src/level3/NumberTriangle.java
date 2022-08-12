package level3;

import java.util.Arrays;

public class NumberTriangle {

    private int mapSize;
    private int[][] map;
    private int[][] cache = new int[500][500];

    public int solution(int[][] triangle) {
        init(triangle);
        return getMinimumPath(0, 0);
    }

    private void init(int[][] triangle) {
        map = triangle;
        mapSize = map.length;

        for (int i = 0; i < mapSize; i++) {
            Arrays.fill(cache[i], -1);
        }
    }

    private int getMinimumPath(int y, int x) {
        if(y >= mapSize) return 0;
        if(cache[y][x] > -1) return cache[y][x];

        return cache[y][x] = Math.max(getMinimumPath(y + 1, x),
                getMinimumPath(y + 1, x + 1)) + map[y][x];
    }
}
