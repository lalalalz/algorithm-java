package level2;

public class Fibonacci {

    private final int MOD = 1234567;
    private long[] fibonacci = new long[100001];

    public int solution(int n) {
        return (int) getNthFibonacci(n);
    }

    private long getNthFibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(fibonacci[n] > 0) return fibonacci[n];
        return fibonacci[n] = (getNthFibonacci(n - 1) +
                getNthFibonacci(n - 2)) % MOD;
    }
}
