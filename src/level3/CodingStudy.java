package level3;

import java.util.HashSet;
import java.util.Set;

public class CodingStudy {

    Set<Integer> solvedProblems = new HashSet<>();

    public int solution(int alp, int cop, int[][] problems) {
        return getMinimumTime(new Info(alp, cop), problems);
    }

    private int getMinimumTime(Info info, int[][] problems) {
        int minimumTime = 0;

        while (problems.length > solvedProblems.size()) {
            minimumTime += solveProblem(info, problems);
        }

        return minimumTime;
    }

    private int solveProblem(Info info, int[][] problems) {
        int time = 0;

        for (int[] problem : problems) {
            int alpReq = problem[0];
            int copReq = problem[1];

            if (info.alp >= alpReq && info.cop >= copReq) {
                int alpRwd = problem[2];
                int copRwd = problem[3];
                int cost   = problem[4];


            }
        }

        return 0;
    }

    public static class Info {
        int alp;
        int cop;
        Set<Integer> solvedProblem = new HashSet<>();

        public Info(int alp, int cop) {
            this.alp = alp;
            this.cop = cop;
        }
    }
}
