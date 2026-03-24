package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import temp.AdmissionRide;


class AdmissionRideTest {

    AdmissionRide admissionRide = new AdmissionRide();

    @Test
    void test() {
        long answer = admissionRide.solution(2500, 0, 2500);
        Assertions.assertEquals(10, answer);
    }
}