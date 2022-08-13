package test;

import level3.Ranking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankingTest {

    Ranking ranking = new Ranking();

    @Test
    void test1() {
        int[][] resultOfGame = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int result = ranking.solution(5, resultOfGame);
        assertEquals(2, result);
    }

}