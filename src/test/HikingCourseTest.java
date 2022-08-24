package test;

import level3.HikingCourse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingCourseTest {

    HikingCourse hikingCourse = new HikingCourse();

    @Test
    void test1() {
        int n = 6;
        int[][] path = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        int[] answer = {5, 3};

        int[] result = hikingCourse.solution(n, path, gates, summits);
        assertArrayEquals(answer, result);
    }

    @Test
    void test2() {
        int n = 7;
        int[][] path = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2},{3, 7, 4},{5, 6, 6}};
        int[] gates = {1};
        int[] summits = {2,3,4};
        int[] answer = {3, 4};

        int[] result = hikingCourse.solution(n, path, gates, summits);
        assertArrayEquals(answer, result);
    }
}