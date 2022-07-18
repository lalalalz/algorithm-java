package test;

import level1.MakeStrangeString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeStrangeStringTest {

    MakeStrangeString makeStrangeString = new MakeStrangeString();

    @Test
    void test1() {
        String strangeStr = makeStrangeString.solution("try hello world");
        assertEquals("TrY HeLlO WoRlD", strangeStr);
    }

    @Test
    void test2() {
        String strangeStr = makeStrangeString.solution("t");
        assertEquals("T", strangeStr);
    }

    @Test
    void test3() {
        String strangeStr = makeStrangeString.solution("w ");
        assertEquals("W ", strangeStr);
    }
}