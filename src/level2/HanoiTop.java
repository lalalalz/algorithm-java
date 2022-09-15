package level2;

import java.util.ArrayList;
import java.util.List;

public class HanoiTop {

    private List<int[]> wayOfHanoiTop = new ArrayList<>();

    public int[][] solution(int n) {
        findWayOfHanoiTop(1, n, 1, 3);
        return wayOfHanoiTop.toArray(new int[wayOfHanoiTop.size()][2]);
    }

    private void findWayOfHanoiTop(int n, int src, int des, int via) {

        if (n == 1) {
            wayOfHanoiTop.add(new int[] {src, des});
        }
        else {
            findWayOfHanoiTop(n - 1, src, via, des);
            wayOfHanoiTop.add(new int[] {src, des});
            findWayOfHanoiTop(n - 1, via, src, des);
        }
    }
}
