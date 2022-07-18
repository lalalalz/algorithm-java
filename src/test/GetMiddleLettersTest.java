package test;

import level1.GetMiddleLetters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetMiddleLettersTest {

    GetMiddleLetters getMiddleLetters = new GetMiddleLetters();

    @Test
    void test() {
        // given
        String input1 = "abcde";
        String input2 = "qwer";
        String input3 = "a";

        // when
        String result1 = getMiddleLetters.solution(input1);
        String result2 = getMiddleLetters.solution(input2);
        String result3 = getMiddleLetters.solution(input3);

        // then
        Assertions.assertEquals("c", result1);
        Assertions.assertEquals("we", result2);
        Assertions.assertEquals("a", result3);
    }

}