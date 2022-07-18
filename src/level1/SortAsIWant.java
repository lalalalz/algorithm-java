package level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortAsIWant {

    public String[] solution(String[] strings, int n) {
        return sort(strings, n);
    }

    private String[] sort(String[] strings, int n) {

        Comparator<String> comparator = new Comparator<String>() {
            private int index = n;

            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(index) > o2.charAt(index)) return 1;
                if(o1.charAt(index) < o2.charAt(index)) return -1;
                return o1.compareTo(o2);
            }
        };


        return Arrays.stream(strings)
                .sorted(comparator)
                .toArray(String[]::new);
    }
}
