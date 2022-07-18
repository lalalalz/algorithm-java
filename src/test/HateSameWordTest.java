package test;

import level1.HateSameWord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HateSameWordTest {

    HateSameWord hateSameWord = new HateSameWord();

    @Test
    void test() {
        //given
        int[] input1 = {1,1,3,3,0,1,1};
        int[] input2 = {4,4,4,3,3};

        //when
        int[] output1 = hateSameWord.solution(input1);
        int[] output2 = hateSameWord.solution(input2);

        //then
        int[] answer1 = {1, 3, 0, 1};
        int[] answer2 = {4, 3};

        assertArrayEquals(answer1, output1);
        assertArrayEquals(answer2, output2);
    }

}