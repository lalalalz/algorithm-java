package test;

import codility.CompareBit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareBitTest {

    CompareBit compareBit = new CompareBit();

    @Test
    void test1() {

        System.out.println();
        int result = compareBit.solution(1073741727, 1073741631, 1073741679);
        assertEquals(8, result);
    }

}