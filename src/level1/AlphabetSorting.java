package level1;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlphabetSorting {

    public String solution(String s) {
        return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}
