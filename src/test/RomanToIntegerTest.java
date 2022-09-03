package test;

import leetCode.RomanToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    void test1() {
        int result = romanToInteger.romanToInt("MCMXCIV");
        assertEquals(1994, result);
    }

    @Test
    void test2() {
        int result = romanToInteger.romanToInt("LVIII");
        assertEquals(58, result);
    }

}