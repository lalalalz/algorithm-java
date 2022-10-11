package test;

import leetCode.LengthOfLastWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLastWordTest {

    LengthOfLastWord solution = new LengthOfLastWord();

    @Test
    void test1() {
        int result = solution.lengthOfLastWord("Hello World");
        assertEquals(5, result);
    }

    @Test
    void test2() {
        int result = solution.lengthOfLastWord("   fly me   to   the moon  ");
        assertEquals(4, result);
    }

    @Test
    void test3() {
        int result = solution.lengthOfLastWord("");
        assertEquals(0, result);
    }
}