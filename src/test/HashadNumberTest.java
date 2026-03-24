package test;

import org.junit.jupiter.api.Test;
import temp.HashadNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashadNumberTest {

    HashadNumber hashadNumber = new HashadNumber();

    @Test
    void test1() {
        boolean result = hashadNumber.solution(10);
        assertEquals(result, true);
    }

    @Test
    void test2() {
        boolean result = hashadNumber.solution(12);
        assertEquals(result, true);
    }

    @Test
    void test3() {
        boolean result = hashadNumber.solution(11);
        assertEquals(result, false);
    }

    @Test
    void test4() {
        boolean result = hashadNumber.solution(13);
        assertEquals(result, false);
    }

}