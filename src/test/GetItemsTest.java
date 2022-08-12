package test;

import level3.GetItems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetItemsTest {

    GetItems getItems = new GetItems();

    @Test
    void test1() {
        int[][] rectangles = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        int result = getItems.solution(rectangles, 1, 3, 7, 8);
        assertEquals(17, result);
    }
}