package level2;

import java.util.Arrays;

public class WorkoutClothes {

    public int solution(int n, int[] lost, int[] reserve) {
        return getMaxStudent(n, lost, reserve);
    }

    private int getMaxStudent(int n, int[] lost, int[] reserve) {
        boolean[] isLost = new boolean[n + 2];

//        setLostStudent(lost, reserve, isLost);
//        lendWorkoutClothes(lost, reserve, isLost);
//
//        return getNumberOfHavingWorkoutClothes(isLost);
        return 1;
    }

//    private int getNumberOfHavingWorkoutClothes(boolean[] isLost) {
//        Arrays.asList(isLost).stream().forEach(System.out::println);
////        Arrays.asList(isLost).stream().filter(s -> !s).count();
//    }
//
//    private void lendWorkoutClothes(int[] lost, int[] reserve, boolean[] isLost) {
//        Arrays.sort(reserve);
//
//        for (int i = 0; i < reserve.length; i++) {
//            if (!hasStolen(reserve[i], lost)) {
//                if (isLost[reserve[i] - 1]) {
//                    isLost[reserve[i] - 1] = false;
//                    continue;
//                }
//                if (isLost[reserve[i] + 1]) {
//                    isLost[reserve[i] + 1] = false;
//                    continue;
//                }
//            }
//        }
//    }
//
//    private boolean hasStolen(int student, int[] lost) {
//        return Arrays.stream(lost)
//                .filter(s -> s == student)
//                .count() > 0;
//    }
//
//    private boolean setLostStudent(int[] lost, int[] reserve, boolean[] isLost) {
//        for (int i = 0; i < lost.length; i++) {
//            if (!hasReserve(lost[i], reserve)) {
//                isLost[lost[i]] = true;
//            }
//        }
//    }
}