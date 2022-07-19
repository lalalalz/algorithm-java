package level2;

public class JumpAndTeleporting {

    private final int MAX = Integer.MAX_VALUE;

    public int solution(int n) {
        return getMinimumUsage(n);
    }

    private int getMinimumUsage(int n) {
        int result = 0;

        if(n == 0) return 0;
        if(n <  0) return MAX;

        if(n % 2 == 0) {
            result = getMinimumUsage(n / 2);
        }
        else {
            result = getMinimumUsage((n - 1) / 2) + 1;
        }

        return result;
    }
}
