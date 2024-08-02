package level2;

import java.util.Comparator;

import static java.util.Arrays.sort;

public class Missile {

    public static void main(String[] args) {
        Missile missile = new Missile();
        int[][] target = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        missile.solution(target);
    }

    public int solution(int[][] targets) {
        sort(targets, Comparator
                .comparingInt((int[] x) -> x[1])
        );
        return getMinimumMissileCount(targets);
    }

    public int getMinimumMissileCount(int[][] sortedTargets) {
        int answer = 0;
        int end = 0;

        for (int i = 0; i < sortedTargets.length; i++) {
            if (end <= sortedTargets[i][0]) {
                end = sortedTargets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
