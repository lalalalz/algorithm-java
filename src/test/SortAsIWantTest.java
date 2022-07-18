package test;

import level1.SortAsIWant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortAsIWantTest {

    private SortAsIWant sortAsIWant = new SortAsIWant();

    private int n = 1;
    private String[] input = {"sun", "bed", "car"};
    private String[] answer1 = {"car", "bed", "sun"};

    private int n2 = 2;
    private String[] input2 = {"abce", "abcd", "cdx"};
    private String[] answer2 = {"abcd", "abce", "cdx"};


    @Test
    void 정렬해보기_같지않을때() {
        String[] result = sortAsIWant.solution(input, n);
        assertArrayEquals(result, answer1);
    }

    @Test
    void 정렬해보기_같을때() {
        String[] result = sortAsIWant.solution(input2, n2);
        assertArrayEquals(result, answer2);
    }

}