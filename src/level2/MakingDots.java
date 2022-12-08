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
        long dd = (long) Math.pow(d, 2);
        long xx = (long) Math.pow(x, 2);
        return (int) Math.sqrt(dd - xx);
    }
}
