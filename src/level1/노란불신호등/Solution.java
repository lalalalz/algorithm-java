package level1.노란불신호등;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[][]{{2, 3, 2}, {3, 1, 3}, {2, 1, 1}});
        System.out.println("solution1 = " + solution1);
    }

    public int solution(int[][] signals) {
        // 사이클 구하기
        int index = 0;
        int[] cycles = new int[signals.length];
        for (int[] signal : signals) {
            cycles[index] += signal[0];
            cycles[index] += signal[1];
            cycles[index] += signal[2];
            index++;
        }

        // LCM 구하기
        int lcm = cycles[0];
        for (int cycle : cycles) {
            lcm = getLCM(lcm, cycle);
        }

        // 정전이 발생하는지 확인하기
        int answer = -1;
        for (int t = 1; t <= lcm; t++) {
            boolean isTurnOff = true;

            for (int signal = 0; signal < signals.length; signal++) {
                if (!isYellowLight(t, cycles[signal], signals[signal])) {
                    isTurnOff = false;
                    break;
                }
            }

            if (isTurnOff) {
                answer = t + 1;
                break;
            }
        }

        return answer;
    }

    private boolean isYellowLight(int t, int cycle, int[] signal) {
        int startSecond = signal[0] + 1;
        int endSecond = startSecond + signal[1];
        int x = t % cycle;
        return startSecond <= x && x < endSecond;
    }

    private int getLCM(int a, int b) {
        return a / getGCD(a, b) * b;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
