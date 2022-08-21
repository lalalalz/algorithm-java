package level3;

public class CodingStudy {

    private int maxReqAlp;
    private int maxReqCop;

    private final int MAX = 0xffffff;
    private int[][] minimumTime = new int[4501][4051];

    public int solution(int alp, int cop, int[][] problems) {
        init(problems);
        return getMinimumTime(alp, cop, problems);
    }

    private void init(int[][] problems) {
        for (int i = 0; i < problems.length; i++) {
            maxReqAlp = Math.max(maxReqAlp, problems[i][0]);
            maxReqCop = Math.max(maxReqCop, problems[i][1]);
        }
    }

    private int getMinimumTime(int alp, int cop, int[][] problems) {
        alp = Math.min(maxReqAlp, alp);
        cop = Math.min(maxReqCop, cop);

        if(alp >= maxReqAlp && cop >= maxReqCop) return 0;
        if(minimumTime[alp][cop] > 0) return minimumTime[alp][cop];

        minimumTime[alp][cop] = MAX;
        if (maxReqAlp >= alp + 1) {
            minimumTime[alp][cop] = Math.min(minimumTime[alp][cop],
                    getMinimumTime(alp + 1, cop, problems) + 1);
        }
        if (maxReqCop >= cop + 1) {
            minimumTime[alp][cop] = Math.min(minimumTime[alp][cop],
                    getMinimumTime(alp, cop + 1, problems) + 1);
        }

        for (int i = 0; i < problems.length; i++) {
            int reqAlp = problems[i][0];
            int reqCop = problems[i][1];

            if (alp >= reqAlp && cop >= reqCop) {
                int rwdAlp = problems[i][2];
                int rwdCop = problems[i][3];
                int cost   = problems[i][4];

                minimumTime[alp][cop] = Math.min(minimumTime[alp][cop],
                        getMinimumTime(alp + rwdAlp, cop + rwdCop, problems) + cost);
            }
        }

        return minimumTime[alp][cop];
    }
}
