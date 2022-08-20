package test;

import level3.SteppingStone;
import level3.SteppingStoneX;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SteppingStoneTest {

    SteppingStone steppingStone = new SteppingStone();

    @Test
    void test1() {
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int result = steppingStone.solution(stones, 3);
        assertEquals(3, result);
    }

    @Test
    void test2() {
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int result = steppingStone.solution(stones, 1);
        assertEquals(1, result);
    }
}