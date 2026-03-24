package test;

import org.junit.jupiter.api.Test;
import temp.MakeStrangeString;

import static org.junit.jupiter.api.Assertions.assertEquals;

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