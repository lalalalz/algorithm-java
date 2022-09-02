package test;

import leetCode.StringToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    StringToInteger stringToInteger = new StringToInteger();

    @Test
    void test1() {
        int result = stringToInteger.myAtoi("42");
        System.out.println("result = " + result);
        assertEquals(42, result);
    }

    @Test
    void test2() {
        int result = stringToInteger.myAtoi("   -42");
        System.out.println("result = " + result);

        assertEquals(-42, result);
    }

    @Test
    void test3() {
        int result = stringToInteger.myAtoi("21474836460");
        System.out.println("result = " + result);

        assertEquals(4193, result);
    }

    @Test
    void test4() {
        int result = stringToInteger.myAtoi("      -11919730356x");
        System.out.println("result = " + result);

        assertEquals(0, result);
    }

    @Test
    void test5() {
        String number = "2147483648";
        String sign = "-1";

        int n = Integer.valueOf(number);
        int s = Integer.valueOf(sign);

        int r = n * s;

        System.out.println("r = " + r);
    }
}