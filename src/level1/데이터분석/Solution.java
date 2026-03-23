package level1.데이터분석;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> columnMap = new HashMap<>();
        columnMap.put("code", 0);
        columnMap.put("date", 1);
        columnMap.put("maximum", 2);
        columnMap.put("remain", 3);

        // 추출
        Integer filteringColumnNumber = columnMap.get(ext);
        Integer sortingColumnNumber = columnMap.get(sort_by);

        return Arrays
                .stream(data)
                .filter(i -> i[filteringColumnNumber] < val_ext) // 필터링
                .sorted(Comparator.comparing(i -> i[sortingColumnNumber])) // 정렬
                .toArray(int[][]::new);
    }
}
