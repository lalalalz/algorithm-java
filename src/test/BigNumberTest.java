package test;

import level2.BigNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {


    BigNumber bigNumber = new BigNumber();

    @Test
    void test1() {
        String result = bigNumber.solution("1924", 2);
        assertTrue(result.equals("94"));
    }

    @Test
    void test2() {
        String result = bigNumber.solution("1231234", 3);
        assertTrue(result.equals("3234"));
    }

    @Test
    void test3() {
        String result = bigNumber.solution("4177252841", 4);
        System.out.println("result = " + result);
        assertTrue(result.equals("775841"));
    }

}