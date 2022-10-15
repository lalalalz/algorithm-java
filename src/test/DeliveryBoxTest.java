package test;

import level2.DeliveryBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryBoxTest {

    DeliveryBox deliveryBox = new DeliveryBox();

    @Test
    void test1() {
        int result = deliveryBox.solution(new int[]{4, 3, 1, 2, 5});
        assertEquals(2, result);
    }

    @Test
    void test2() {
        int result = deliveryBox.solution(new int[]{5,4,3,2,1});
        assertEquals(5, result);
    }
}