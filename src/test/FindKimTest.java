package test;

import level1.programmers.FindKim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKimTest {

    FindKim findKim = new FindKim();

    @Test
    void test1() {
        String[] input = {"Jane", "Kim"};
        String output = findKim.solution(input);
        assertEquals("김서방은 1에 있다", output);
    }

    @Test
    void test2() {
        String[] input = {"hello", "Jane", "Kim"};
        String output = findKim.solution(input);
        assertEquals("김서방은 2에 있다", output);
    }

}