package test;

import level3.WayToSchool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WayToSchoolTest {

    WayToSchool wayToSchool = new WayToSchool();

    @Test
    void test1() {
        int result = wayToSchool.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assertEquals(4, result);
    }

}