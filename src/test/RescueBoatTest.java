package test;

import level2.RescueBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RescueBoatTest {

    RescueBoat rescueBoat = new RescueBoat();

    @Test
    void test1() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int result = rescueBoat.solution(people, limit);
        assertEquals(3, result);
    }

}