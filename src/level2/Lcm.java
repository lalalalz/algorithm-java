package level2;

public class Lcm {
    public int solution(int[] arr) {
        return getLcm(arr);
    }

    private int getLcm(int[] arr) {
        int result = 1;

        for (int number : arr) {
            result = lcm(number, result);
        }

        return result;
    }

    private int lcm(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return a * b / gcd(a, b);
    }

    private int gcd(int bigger, int smaller) {
        if(smaller == 0) return bigger;
        return gcd(smaller, bigger % smaller);
    }
}
