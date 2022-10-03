package level1;

import java.util.ArrayList;
import java.util.List;

public class MinimumArea {

    public int solution(int[][] sizes) {
        return getMinimumArea(sizes);
    }

    private int getMinimumArea(int[][] sizes) {
        List<Integer> width  = new ArrayList<>();
        List<Integer> height = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {
            width.add(Math.max(sizes[i][0], sizes[i][1]));
            height.add(Math.min(sizes[i][0], sizes[i][1]));
        }

        return width.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt()
                *
                height.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }
}
