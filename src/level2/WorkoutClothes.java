package level2;

import java.util.Arrays;

public class WorkoutClothes {

    public int solution(int n, int[] lost, int[] reserve) {
        return getMaxStudent(n, lost, reserve);
    }

    private int getMaxStudent(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n + 2];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        setLostStudent(lost, reserve, isLost);
        lendWorkoutClothes(lost, reserve, isLost);

        return getNumberOfHavingWorkoutClothes(isLost);
    }

    private void lendWorkoutClothes(int[] lost, int[] reserve, boolean[] isLost) {
        for (int i = 0; i < reserve.length; i++) {
            if (!hasStolen(reserve[i], lost)) {
                if (isLost[reserve[i] - 1]) {
                    isLost[reserve[i] - 1] = false;
                    continue;
                }
                if (isLost[reserve[i] + 1]) {
                    isLost[reserve[i] + 1] = false;
                    continue;
                }
            }
        }
    }

    private void setLostStudent(int[] lost, int[] reserve, boolean[] isLost) {
        for (int i = 0; i < lost.length; i++) {
            if (!hasReserve(lost[i], reserve)) {
                isLost[lost[i]] = true;
            }
        }
    }

    private int getNumberOfHavingWorkoutClothes(boolean[] hasWorkoutClothes) {
        int result = 0;

        for (int i = 1; i < hasWorkoutClothes.length - 1; i++) {
            if (!hasWorkoutClothes[i]) {
                result++;
            }
        }

        return result;
    }

    private boolean hasReserve(int student, int[] reserve) {
        return Arrays.stream(reserve)
                .filter(s -> s == student)
                .count() > 0;
    }

    private boolean hasStolen(int student, int[] lost) {
        return Arrays.stream(lost)
                .filter(s -> s == student)
                .count() > 0;
    }
}
