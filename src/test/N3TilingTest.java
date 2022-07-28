package test;

import level2.N3Tiling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N3TilingTest {

    N3Tiling n3Tiling = new N3Tiling();

    @Test
    void test1() {
        int result = n3Tiling.solution(4);
        assertEquals(11, result);
    }

}