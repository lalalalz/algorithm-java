package test;

import level1.programmers.CoveringNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoveringNumberTest {

    CoveringNumber coveringNumber = new CoveringNumber();

    @Test
    void test1() {
        String result = coveringNumber.solution("01033334444");

        System.out.println("result = " + result);
        assertEquals(result.equals("*******4444"), true);
    }

    @Test
    void test2() {
        String result = coveringNumber.solution("027778888");

        System.out.println("result = " + result);
        assertEquals(result.equals("*****8888"), true);
    }

    @Test
    void test3() {
        String result = coveringNumber.solution("1234");

        System.out.println("result = " + result);
        assertEquals(result.equals("1234"), true);
    }
}