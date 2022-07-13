package test;

import level1.programmers.CheckString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckStringTest {

    CheckString checkString = new CheckString();

    @Test
    void test1() {
        boolean isTrue = checkString.solution("a234");
        Assertions.assertEquals(false, isTrue);
    }

    @Test
    void test2() {
        boolean isTrue = checkString.solution("1234");
        Assertions.assertEquals(true, isTrue);
    }

    @Test
    void test3() {
        boolean isTrue = checkString.solution("12345");
        Assertions.assertEquals(false, isTrue);
    }

    @Test
    void test4() {
        boolean isTrue = checkString.solution("123456");
        Assertions.assertEquals(true, isTrue);
    }

    @Test
    void test5() {
        boolean isTrue = checkString.solution("12345a");
        Assertions.assertEquals(false, isTrue);
    }

    @Test
    void test6() {
        boolean isTrue = checkString.solution("1234567");
        Assertions.assertEquals(false, isTrue);
    }
}