package test;

import leetCode.GenerateParentheses;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    GenerateParentheses solution = new GenerateParentheses();

    @Test
    void test1() {
        List<String> result = solution.generateParenthesis(3);
        result.forEach(System.out::println);
    }

}