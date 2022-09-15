package level2;

import java.util.ArrayList;
import java.util.List;

public class HanoiTopVersion2 {

    private List<int[]> wayOfHanoiTop = new ArrayList<>();

    public int[][] solution(int n) {
        findWayOfHanoiTop(n, 1, 2, 3);
        return wayOfHanoiTop.toArray(new int[wayOfHanoiTop.size()][2]);
    }

    private void findWayOfHanoiTop(int n, int src, int via, int des) {

        if (n == 1) {
            wayOfHanoiTop.add(new int[]{src, des});
            return;
        }

        findWayOfHanoiTop(n - 1, src, via, des);
        wayOfHanoiTop.add(new int[]{src, des});
        findWayOfHanoiTop(n - 1, via, src, des);
    }
}
