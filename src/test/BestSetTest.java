package test;

import level2.BestSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestSetTest {

    BestSet bestSet = new BestSet();

    @Test
    void test1() {
        int[] result = bestSet.solution(2, 9);

        for (int i : result) {
            System.out.println("i = " + i);
        }

        assertArrayEquals(new int[]{4, 5}, result);
    }

}