package level1.programmers;

import java.util.ArrayList;
import java.util.List;

public class DiviseNumber {

    public int[] solution(int[] arr, int divisor) {
        return getDiviseNumberArray(arr, divisor);
    }

    private int[] getDiviseNumberArray(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();

        for (int number : arr) {
            if (number % divisor == 0) {
                result.add(number);
            }
        }

        if(result.size() == 0) result.add(-1);

        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
