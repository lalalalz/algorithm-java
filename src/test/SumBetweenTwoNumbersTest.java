package test;

import level1.SumBetweenTwoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumBetweenTwoNumbersTest {

    SumBetweenTwoNumbers sumBetweenTwoNumbers = new SumBetweenTwoNumbers();

    @Test
    @DisplayName("1부터 3까지의 합")
    void 테스트_1부터3까지의합() {
        long answer1 = sumBetweenTwoNumbers.solution(1, 3);
        assertEquals(6, answer1);

        long answer2 = sumBetweenTwoNumbers.solution(3, 1);
        assertEquals(6, answer2);
    }


    @Test
    @DisplayName("-3부터 3까지의 합")
    void 테스트_음수에서양수까지의합() {
        long answer1 = sumBetweenTwoNumbers.solution(-3, 3);
        assertEquals(0, answer1);

        long answer2 = sumBetweenTwoNumbers.solution(-3, 3);
        assertEquals(0, answer2);
    }
}