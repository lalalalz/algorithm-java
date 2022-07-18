package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickNumberAndPlus {

    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
