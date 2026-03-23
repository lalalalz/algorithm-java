package level1.체육복;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] lostMemberList = new boolean[n + 1];
        boolean[] reserveMemberList = new boolean[n + 1];

        // 잃어버린 회원 목록 갱신
        for (int i : lost) {
            lostMemberList[i] = true;
        }

        // 여벌 회원 목록 갱신
        int count = 0;
        for (int i : reserve) {
            reserveMemberList[i] = true;
            if (lostMemberList[i]) {
                lostMemberList[i] = false;
                reserveMemberList[i] = false;
                count++;
            }
        }

        // 그리디 전략으로 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (!reserveMemberList[i]) {
                continue;
            }

            if (i - 1 >= 1 && lostMemberList[i - 1]) {
                lostMemberList[i - 1] = false;
                count++;
            }
            else if (i + 1 <= n && lostMemberList[i + 1]) {
                lostMemberList[i + 1] = false;
                count++;
            }
        }

        return n - lost.length + count;
    }
}