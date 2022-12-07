package level2;

public class MakingDots {

    public long solution(int k, int d) {
        int result = 0;

        for (int x = 0; x <= d; x += k) {
            int maxY = getMaxY(d, x);
            result += maxY / k + 1;
        }

        return result;
    }

    private int getMaxY(int d, int x) {
        long ySquare = (long)d * d - (long)x * x;
        return (int) Math.sqrt(ySquare);
    }
}
