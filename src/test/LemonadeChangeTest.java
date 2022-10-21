package test;

import leetCode.LemonadeChange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LemonadeChangeTest {

    LemonadeChange solution = new LemonadeChange();

    @Test
    void test1() {
        int[] bills = {5, 5, 5, 10, 20};
        boolean result = solution.lemonadeChange(bills);
        assertTrue(result);
    }

    @Test
    void test2() {
        int[] bills = {5, 5, 5, 10, 20};
        boolean result = solution.lemonadeChange(bills);
        assertFalse(result);
    }
}