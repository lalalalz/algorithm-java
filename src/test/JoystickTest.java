package test;

import level2.Joystick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoystickTest {

    Joystick joystick = new Joystick();

    @Test
    void test1() {
        int result = joystick.solution("JEROEN");
        assertEquals(56, result);
    }

    @Test
    void test2() {
        int result = joystick.solution("JAN");
        assertEquals(23, result);
    }
}