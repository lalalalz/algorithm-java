package test;

import org.junit.jupiter.api.Test;
import temp.SortOfInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortOfIntegerTest {

    SortOfInteger sortOfInteger = new SortOfInteger();

    @Test
    void test1() {
        long result = sortOfInteger.solution(118372);

        System.out.println("result = " + result);

        assertEquals(result, 873211);

    }

}