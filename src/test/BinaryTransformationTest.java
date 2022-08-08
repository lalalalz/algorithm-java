package test;

import level2.BinaryTransformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTransformationTest {

    BinaryTransformation binaryTransformation = new BinaryTransformation();

    @Test
    void test1() {
        int[] result = binaryTransformation.solution("110010101001");
        assertArrayEquals(new int[]{3, 8}, result);
    }
}