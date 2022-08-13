package level3;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Ranking {

    private Set<Integer>[] winnerList = new ConcurrentHashMap.KeySetView[101];
    private Set<Integer>[] loserList = new ConcurrentHashMap.KeySetView[101];

    public int solution(int n, int[][] resultOfGame) {
        return getRankedMemberNumber(n, resultOfGame);
    }

    private int getRankedMemberNumber(int n, int[][] resultOfGame) {
        int rankedMemberNumber = 0;

        for (int i = 0; i < n; i++) {
            winnerList[i] = ConcurrentHashMap.newKeySet();
            loserList[i] = ConcurrentHashMap.newKeySet();
        }

        for (int i = 0; i < resultOfGame.length; i++) {
            int winner = resultOfGame[i][0] - 1;
            int loser  = resultOfGame[i][1] - 1;

            winnerList[loser].add(winner);
            loserList[winner].add(loser);
        }

        for (int i = 0; i < n; i++) {
            for (Integer winner : winnerList[i]) {
                loserList[winner].addAll(loserList[i]);
            }

            for (Integer loser : loserList[i]) {
                winnerList[loser].addAll(winnerList[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (winnerList[i].size() + loserList[i].size() == n - 1) {
                rankedMemberNumber++;
            }
        }

        return rankedMemberNumber;
    }
}
