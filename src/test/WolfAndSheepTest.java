package test;

import level3.WolfAndSheep;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WolfAndSheepTest {

    WolfAndSheep wolfAndSheep = new WolfAndSheep();

    @Test
    void test1() {
        int result = wolfAndSheep.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
        assertEquals(5, result);
    }

}