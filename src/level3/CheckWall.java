package level3;

import java.util.ArrayList;
import java.util.List;

public class CheckWall {

    private int minimumChecker;
    private static final int MAX = Integer.MAX_VALUE;

    private int[] weak;
    private int[] dist;
    private boolean[] isUsed = new boolean[8];

    public int solution(int n, int[] w, int[] d) {
        init(w, d);
        permutation(0, new ArrayList<>());

        if(minimumChecker >= MAX) return -1;
        return minimumChecker;
    }

    private void init(int[] w, int[] d) {
        weak = w;
        dist = d;
        minimumChecker = MAX;
    }

    private void permutation(int count, List<Integer> checker) {
        if (count == dist.length) {
            minimumChecker = Math.min(minimumChecker, setChecker(checker));
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (isUsed[i] == false) {
                isUsed[i] = true;
                checker.add(i);
                permutation(count + 1, checker);
                checker.remove(i);
                isUsed[i] = false;
            }
        }
    }

    private int setChecker(List<Integer> checker) {
        int numberOfUsed = 0;

        // 첫 지점 선택
        for (int i = 0; i < weak.length; i++) {
            for (int j = 0; j < checker.size(); j++) {

            }
        }

        return 0;
    }
}
