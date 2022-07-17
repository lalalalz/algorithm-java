package level1.programmers;

import java.util.Arrays;

public class GetAverage {

    public double solution(int[] arr) {
        return (double)Arrays.stream(arr).sum() / arr.length;
    }
}
