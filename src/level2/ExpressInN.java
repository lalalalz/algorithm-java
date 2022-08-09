package level2;

public class ExpressInN {

    private final int MAX = 32001;
    private int[] cache = new int[32001];

    public int solution(int n, int number) {
        return getMinimumOperation(n, number);
    }

    private int getMinimumOperation(int n, int number) {
        if(n == 0) return 1;
        if(n <  0) return MAX;

        if(cache[n] < MAX) return cache[n];

        for (int i = 0; i < 4; i++) {
            cache[n] = Math.min(cache[n], operate(n, number, i));
        }

        return cache[n];
    }

    private int operate(int n, int number, int operator) {
        if(operator == 0) return n + number;
        if(operator == 1) return n - n;
        return 1;
    }
}