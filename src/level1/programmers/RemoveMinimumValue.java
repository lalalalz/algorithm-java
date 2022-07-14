package level1.programmers;

import java.util.Arrays;

public class RemoveMinimumValue {

    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};

        int minimumValue = Arrays.stream(arr)
                .min()
                .getAsInt();

        return Arrays.stream(arr)
                .filter(x -> x != minimumValue)
                .toArray();
    }
}
