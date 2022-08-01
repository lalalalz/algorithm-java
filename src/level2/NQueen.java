package level2;

public class NQueen {

    private boolean[] row = new boolean[1025];
    private boolean[] col = new boolean[1025];
    private boolean[] left = new boolean[1025];
    private boolean[] right = new boolean[1025];
    private boolean[][] map = new boolean[1025][1025];

    public int solution(int n) {
        return bruteForce(0, 1, n);
    }

    private int bruteForce(int y, int x, int n) {
        int result = 0;

        if(n == 0) return 1;
        if(y >= n) return 0;
        if(x >= n) return bruteForce(y + 1, x, n);

        result = bruteForce(y, x + 1, n);
        if (!row[y] && !col[x] && !left[y + x] && !right[y + x]) {
            result += bruteForce(y, x + 1, n - 1);
        }

        return result;
    }
}
