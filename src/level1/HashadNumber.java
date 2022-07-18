package level1;

public class HashadNumber {

    public boolean solution(int x) {
        int sum = sumOfDigits(x);
        return isHashadNumber(x, sum);
    }

    private int sumOfDigits(int x) {
        return String.valueOf(x)
                .chars()
                .map(n -> n - '0')
                .sum();
    }

    private boolean isHashadNumber(int x, int sum) {
        return x % sum == 0;
    }
}
