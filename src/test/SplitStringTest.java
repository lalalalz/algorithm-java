package test;

import level1.SplitString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitStringTest {

    SplitString splitString = new SplitString();


    @Test
    void test1() {
        int result = splitString.solution("banana");
        assertEquals(3, result);
    }

    @Test
    void test2() {
        int result = splitString.solution("abracadabra");
        assertEquals(6, result);
    }

    @Test
    void test3() {
        int result = splitString.solution("aaabbaccccabba");
        assertEquals(3, result);
    }
}