package level2;

public class ExpressionOfNumber {

    public int solution(int n) {
        return getCount(n);
    }

    private int getCount(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (canExpress(i, n)) {
                count++;
            }
        }

        return count;
    }

    private boolean canExpress(int i, int n) {
        int sum = 0;

        while (sum < n) {
            sum += i;
            i++;
        }

        return sum == n;
    }
}
