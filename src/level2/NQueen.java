package level2;

public class NQueen {

    private boolean[] col = new boolean[1025];
    private boolean[] left = new boolean[1025];
    private boolean[] right = new boolean[1025];
    private boolean[][] map = new boolean[1025][1025];

    public int solution(int n) {
        return bruteForce(0, n);
    }

    private int bruteForce(int y, int n) {
        int result = 0;

        if(n == 0) return 1;
        if(y >= n) return 0;

        for (int i = 0; i < n; i++) {
            if (!col[i] && !left[y + i + 1] && !right[n - (y + i)]) {
                col[i] = true; left[y + i + 1] = true; right[n - (y + i)] = true;
                result += bruteForce(y + 1, n - 1);
                col[i] = false; left[y + i + 1] = false; right[n - (y + i)] = false;
            }
        }

        return result;
    }
}
