package level2;

public class NQueen {

    private boolean[] isUsedX = new boolean[12];
    private boolean[] isUsedY = new boolean[12];
    private boolean[] isUsedCrossY = new boolean[23];
    private boolean[] isUsedCrossX = new boolean[23];

    public int solution(int n) {
        return getCountOfAllWay(-1, 0, n);
    }

    private int getCountOfAllWay(int index, int countOfQueens, int n) {
        int result = 0;

        if (index >= n * n) {
            return countOfQueens == n ? 1 : 0;
        }

        // 다음번에 안놓기
        result += getCountOfAllWay(index + 1, countOfQueens, n);
        // 다음번에 놓기
        for (int i = index + 1; i < n * n; i++) {
            int nextY = i / n;
            int nextX = i % n;

            if (!isUsedY[nextY] && !isUsedCrossY[nextY + nextX]
                    && !isUsedX[nextX] && !isUsedCrossX[nextX + (n - nextY)]) {
                isUsedY[nextY] = true;
                isUsedX[nextX] = true;
                isUsedCrossY[nextY + nextX] = true;
                isUsedCrossX[nextX + (n - nextY)] = true;
                result += getCountOfAllWay(i, countOfQueens + 1, n);
                isUsedY[nextY] = false;
                isUsedX[nextX] = false;
                isUsedCrossY[nextY + nextX] = false;
                isUsedCrossX[nextX + (n - nextY)] = false;
            }
        }

        return result;
    }

    private int getCountOfAllWay2(int index, int countOfQueens, int n) {
        int result = 0;

        if (index >= n * n) {
            return countOfQueens == n ? 1 : 0;
        }

        int y = index / n;
        int x = index % n;

        result += getCountOfAllWay(index + 1, countOfQueens, n);
        if (!isUsedY[y] && !isUsedX[x] && !isUsedCrossY[y + x] && !isUsedCrossX[x + (n - y)]) {
            isUsedY[y] = true;
            isUsedX[x] = true;
            isUsedCrossY[y + x] = true;
            isUsedCrossX[x + (n - y)] = true;
            result += getCountOfAllWay(getNext(index, n), countOfQueens + 1, n);
            isUsedY[y] = false;
            isUsedX[x] = false;
            isUsedCrossY[y + x] = false;
            isUsedCrossX[x + (n - y)] = false;
        }

        return result;
    }

    private int getNext(int index, int n) {
        for (int i = index; i < n * n; i++) {
            int y = i / n;
            int x = i % n;

            if (!isUsedY[y] && !isUsedX[x] && !isUsedCrossY[y + x] && !isUsedCrossX[x + (n - y)]) {
                return i;
            }
        }

        return n * n;
    }
}
