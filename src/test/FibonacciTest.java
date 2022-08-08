package test;

import level2.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    void test1() {
        int result = fibonacci.solution(3);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        int result = fibonacci.solution(5);
        assertEquals(5, 5);
    }
}