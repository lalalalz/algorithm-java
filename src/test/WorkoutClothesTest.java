package test;

import level2.WorkoutClothes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutClothesTest {

    WorkoutClothes workoutClothes = new WorkoutClothes();

    @Test
    void test1() {
        int result = workoutClothes.solution(5, new int[]{2, 4}, new int[]{1, 3, 5});
        assertEquals(5, result);
    }

    @Test
    void test2() {
        int result = workoutClothes.solution(5, new int[]{2, 4}, new int[]{3});
        assertEquals(4, result);
    }

    @Test
    void test3() {
        int result = workoutClothes.solution(3, new int[]{3}, new int[]{1});
        assertEquals(2, result);
    }

    @Test
    void test4() {
        int result = workoutClothes.solution(3, new int[]{1, 3}, new int[]{1});
        assertEquals(2, result);
    }
}