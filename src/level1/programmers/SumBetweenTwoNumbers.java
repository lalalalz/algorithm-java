package level1.programmers;

public class SumBetweenTwoNumbers {

    public long solution(int a, int b) {
        return getSumBetweenTwoNumbers(a, b);
    }

    private long getSumBetweenTwoNumbers(int a, int b) {
        long n = Math.abs(a - b) + 1;
        long sum = a + b;

        // 홀수개
        if (n % 2 > 0) return (long)(sum * (n / 2 + (double)1 / 2));
        return sum * n / 2;
    }
}
