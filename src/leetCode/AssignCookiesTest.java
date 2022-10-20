package leetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignCookiesTest {

    AssignCookies solution = new AssignCookies();

    @Test
    void test1() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        int result = solution.findContentChildren(g, s);
        assertEquals(1, result);
    }

    @Test
    void test2() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};

        int result = solution.findContentChildren(g, s);
        assertEquals(2, result);
    }
}