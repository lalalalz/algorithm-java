package test;

import level2.Delivery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {


    Delivery delivery = new Delivery();

    @Test
    void test1() {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int result = delivery.solution(5, road, 3);
        assertEquals(4, result);
    }
}