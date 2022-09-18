package kakakoHair;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem1 {
    public int solution(int N) {
        return getSum(N);
    }

    private int getSum(int n) {
        String[] numbers = String.valueOf(n).split("");

        String ascendingOrder = Stream.of(numbers).sorted().collect(Collectors.joining());
        String descendingOrder = Stream.of(numbers).sorted(Comparator.reverseOrder()).collect(Collectors.joining());

        return Integer.parseInt(ascendingOrder) + Integer.parseInt(descendingOrder);
    }
}
