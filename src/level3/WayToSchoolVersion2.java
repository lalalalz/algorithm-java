package level3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class WayToSchoolVersion2 {

    private static final int LIMIT = 1000000007;
    private static final int PUDDLE = 1;

    private int[][] minimumSteps = new int[101][101];
    private int[][] positionOfPuddles = new int[101][101];

    public int solution(int m, int n, int[][] puddles) {
        setPositionOfPuddles(puddles);
        findMinimumStepToSchool(n, m);
        return getMinimumStepToSchool(m, n);
    }

    private int getMinimumStepToSchool(int m, int n) {
        return minimumSteps[n][m];
    }

    private int findMinimumStepToSchool(int y, int x) {

        if(y == 1 && x == 1) return 1;
        if(minimumSteps[y][x] > 0) return minimumSteps[y][x];

        if (y - 1 >= 1 && positionOfPuddles[y - 1][x] != PUDDLE) {
            minimumSteps[y][x] =
                    (minimumSteps[y][x] + findMinimumStepToSchool(y - 1, x)) % LIMIT;
        }
        if (x - 1 >= 1 && positionOfPuddles[y][x - 1] != PUDDLE) {
            minimumSteps[y][x] =
                    (minimumSteps[y][x] + findMinimumStepToSchool(y, x - 1)) % LIMIT;
        }

        return minimumSteps[y][x];
    }

    private void setPositionOfPuddles(int[][] puddles) {
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            positionOfPuddles[y][x] = PUDDLE;
        }
    }
}
