package test;

import level2.HIndex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HIndexTest {

    HIndex hIndex = new HIndex();

    @Test
    void test1() {
        int[] citations = {3, 0, 6, 1, 5};
        int result = hIndex.solution(citations, 3);
        assertEquals(3, result);
    }

}