package test;

import level3.WayToSchoolVersion2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WayToSchoolVersion2Test {

    WayToSchoolVersion2 wayToSchoolVersion2 = new WayToSchoolVersion2();

    @Test
    void test1() {
        int result = wayToSchoolVersion2.solution(4, 3, new int[][]{{2, 2}});
        assertEquals(4, result);

    }

}