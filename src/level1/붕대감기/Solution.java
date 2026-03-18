package level1.붕대감기;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}});
        System.out.println("solution1 = " + solution1);
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int currentTime = 0;
        int castingTime = bandage[0];
        int recoveryAmount = bandage[1];
        int additionalRecoveryAmount = bandage[2];

        for (int[] attack : attacks) {
            int attackedTime = attack[0];
            int attackAmount = attack[1];
            int castingCount = (attackedTime - currentTime) / castingTime;
            int remainTime = (attackedTime - currentTime) % castingTime;

            answer = Math.min(health, answer + castingCount * (castingTime * recoveryAmount + additionalRecoveryAmount));
            answer = Math.min(health, answer + remainTime * recoveryAmount);
            answer -= attackAmount;
            currentTime = attackedTime + 1;

            if (answer <= 0) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
