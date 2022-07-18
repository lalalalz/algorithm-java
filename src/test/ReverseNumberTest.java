package test;

import level1.ReverseNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNumberTest {

    ReverseNumber reverseNumber = new ReverseNumber();

    @Test
    void test1() {
        int[] result = reverseNumber.solution(12345L);
        assertArrayEquals(result, new int[]{5, 4, 3, 2, 1});
    }

}