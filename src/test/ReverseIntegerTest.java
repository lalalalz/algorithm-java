package test;

import leetCode.ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void test1() {
        int result = reverseInteger.reverse(1534236469);
        assertEquals(321, result);
    }
}