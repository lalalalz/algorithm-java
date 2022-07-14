package level1.programmers;

import java.util.Arrays;

public class SumOfDigits {

    public int solution(int n) {
        return separateDigitsAndSum(n);
    }

    private int separateDigitsAndSum(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
