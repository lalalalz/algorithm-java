package test;

import level2.JadenCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JadenCaseTest {

    JadenCase jadenCase = new JadenCase();

    @Test
    void test1() {
        String input = "3people unFollowed me";
        String answer = "3people Unfollowed Me";

        String result = jadenCase.solution(input);
        assertEquals(true, result.equals(answer));
    }

    @Test
    void test2() {
        String input = "for the last week";
        String answer = "For The Last Week";

        String result = jadenCase.solution(input);
        assertEquals(true, result.equals(answer));
    }

    @Test
    void test3() {
        String input = "for the   last week ";
        String answer = "For The   Last Week ";

        String result = jadenCase.solution(input);
        assertEquals(true, result.equals(answer));
    }
}