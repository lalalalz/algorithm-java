package test;

import leetCode.SearchInsertPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    SearchInsertPosition solution = new SearchInsertPosition();

    @Test
    void test1() {
        int result = solution.searchInsert(new int[]{1, 3, 5, 6}, 5);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        int result = solution.searchInsert(new int[]{1, 3, 5, 6}, 2);
        assertEquals(1, result);
    }

    @Test
    void test3() {
        int result = solution.searchInsert(new int[]{1, 3, 5, 6}, 7);
        assertEquals(4, result);
    }

    @Test
    void test4() {
        int result = solution.searchInsert(new int[]{1, 3}, 0);
        assertEquals(0, result);
    }
}