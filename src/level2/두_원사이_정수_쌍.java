package level2;

public class 두_원사이_정수_쌍 {

    public long solution(int r1, int r2) {
        long count = 0;

        for (int i = r1; i <= r2; i++) {
            long y2 = (long) Math.round(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            long y1 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            count += y2 - y1 + 1;
        }

        return count * 4;
    }
}
