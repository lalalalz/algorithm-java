package level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortOfInteger {

    public long solution(long n) {
        String result = Arrays.stream(String.valueOf(n).split(""))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining(""));

        return Long.valueOf(result);
    }
}
