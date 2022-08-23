package test;

import level2.MakeSameQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeSameQueueTest {

    MakeSameQueue makeSameQueue = new MakeSameQueue();

    @Test
    void test1() {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int result = makeSameQueue.solution(queue1, queue2);
        assertEquals(2, result);
    }

}