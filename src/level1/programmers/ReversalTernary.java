package level1.programmers;

public class ReversalTernary {

    public int solution(int n) {
        String TernaryNumber = makeTernaryAndReverse(n);
        return generateNumber(TernaryNumber);
    }

    private String makeTernaryAndReverse(int n) {
        String result = "";

        while (n > 0) {
            result += String.valueOf(n % 3);
            n /= 3;
        }

        return result;
    }

    private int generateNumber(String ternaryNumber) {
        int result = 0;
        int multiple = 1;

        for (int i = ternaryNumber.length() - 1; i >= 0; i--) {
            result += ((ternaryNumber.charAt(i) - '0') * multiple);
            multiple *= 3;
        }

        return result;
    }
}
