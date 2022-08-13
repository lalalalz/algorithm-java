package test;

import level3.Network;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkTest {

    Network network = new Network();

    @Test
    void test1() {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = network.solution(3, computers);
        assertEquals(2, result);

    }
}