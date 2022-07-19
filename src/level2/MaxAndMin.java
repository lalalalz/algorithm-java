package level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxAndMin {

    public String solution(String s) {
        List<String> strings = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj((i) -> String.valueOf(i))
                .collect(Collectors.toList());
        
        return strings.get(0) + " " + strings.get(strings.size() - 1);
    }
}
