package level1;

import java.util.ArrayList;
import java.util.List;

public class HateSameWord {

    public int[] solution(int[] arr) {
        return deDuplication(arr);
    }

    private int[] deDuplication(int[] arr) {
        int prevNumber = -1;
        List<Integer> result = new ArrayList<>();

        for (int number : arr) {
            if (prevNumber != number) {
                result.add(number);
                prevNumber = number;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
