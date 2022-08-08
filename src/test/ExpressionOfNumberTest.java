package test;

import level2.ExpressionOfNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionOfNumberTest {

    ExpressionOfNumber expressionOfNumber = new ExpressionOfNumber();

    @Test
    void test1() {
        int result = expressionOfNumber.solution(15);
        assertEquals(4, result);
    }

}