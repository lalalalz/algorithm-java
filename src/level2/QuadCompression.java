package level2;

public class QuadCompression {

    private int[][] map;
    private int size;

    public int[] solution(int[][] arr) {
        init(arr);
        return quadCompression(arr);
    }

    private void init(int[][] arr) {
        map  = arr;
        size = arr.length;
    }

    private int[] quadCompression(int[][] arr) {
        return compress(0, 0, size);
    }

    private int[] compress(int y, int x, int size) {
        int mid = size / 2;
        int[] result = {0, 0};

        if (isUnique(y, x, size)) {
            result[map[y][x]] = 1;
            return result;
        }

        int[][] resultArray = {
                compress(y, x, mid),
                compress(y, x + mid, mid),
                compress(y + mid, x, mid),
                compress(y + mid, x + mid, mid)
        };

        for (int i = 0; i < resultArray.length; i++) {
            int countsOfZero = resultArray[i][0];
            int countsOfOne = resultArray[i][1];

            result[0] += countsOfZero;
            result[1] += countsOfOne;
        }

        return result;
    }

    private boolean isUnique(int y, int x, int size) {
        int uniqueValue = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (uniqueValue != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
