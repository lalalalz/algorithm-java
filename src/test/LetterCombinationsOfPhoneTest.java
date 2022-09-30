package test;

import leetCode.LetterCombinationsOfPhone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfPhoneTest {

    LetterCombinationsOfPhone solution = new LetterCombinationsOfPhone();

    @Test
    void test1() {
        List<String> result = solution.letterCombinations("23");
        result.forEach(System.out::println);
    }

    @Test
    void test2() {
        List<String> result = solution.letterCombinations("");
        result.forEach(System.out::println);
    }
}