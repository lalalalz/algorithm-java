package level1.유연근무제;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{700, 800, 1100}, new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5);
        System.out.println("solution1 = " + solution1);
    }

    public int solution(int[] schedules, int[][] timeLogs, int sd) {
        int answer = 0;
        // 시간을 모두 분단위로 변환한다.
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] = convert(schedules[i]);
        }

        for (int[] timeLog : timeLogs) {
            for (int i = 0; i < timeLog.length; i++) {
                timeLog[i] = convert(timeLog[i]);
            }
        }

        // 사원마다 출근을 확인한다.
        for (int i = 0; i < timeLogs.length; i++) {
            int startDay = sd - 1;
            boolean hasLateDay = false;

            // 해당 i 사원의 한주의 출근시간을 확인한다.
            for (int time : timeLogs[i]) {
                if (isWeekend(startDay++)) {
                    continue;
                }

                if (isLate(time, schedules[i])) {
                    hasLateDay = true;
                    break;
                }
            }

            if (!hasLateDay) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isWeekend(int startDay) {
        return startDay % 7 >= 5;
    }

    private boolean isLate(int time, int schedule) {
        return time > schedule + 10;
    }

    private int convert(int time) {
        return (time / 100) * 60 + time % 100;
    }
}
