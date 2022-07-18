package test;

import level2.SquidGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquidGameTest {

    SquidGame squidGame = new SquidGame();

    @Test
    void test1() {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        int result = squidGame.solution(land);

        assertEquals(result, 16);
    }

}