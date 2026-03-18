package level1.공원;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] mats, String[][] park) {
        // 크기순으로 정렬
        List<Integer> reverseOrderedMats = Arrays
                .stream(mats)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // 돗자리 마다 공원 모든 경우의 수에 배치해본다.
        for (Integer reverseOrderedMat : reverseOrderedMats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (park[i][j].equals("-1")) {
                        if (check(i, j, reverseOrderedMat, park)) {
                            return reverseOrderedMat;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean check(int y, int x, int matSize, String[][] park) {
        for (int i = y; i < y + matSize; i++) {
            for (int j = x; j < x + matSize; j++) {
                if (i >= park.length || j >= park[0].length || !park[i][j].equals("-1")
                ) {
                    return false;
                }
            }
        }

        return true;
    }
}
