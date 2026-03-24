package test;

import org.junit.jupiter.api.Test;
import temp.NearestSameString;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NearestSameStringTest {

    NearestSameString nearestSameString = new NearestSameString();

    @Test
    void test1() {
        int[] result = nearestSameString.solution("banana");
        int[] expected = {-1, -1, -1, 2, 2, 2};
        assertArrayEquals(expected, result);
    }

}