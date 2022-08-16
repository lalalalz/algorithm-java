package test;

import level3.BlackClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackClientTest {

    BlackClient blackClient = new BlackClient();

    @Test
    void test1() {
        String[] userIds = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedIds = {"fr*d*", "abc1**"};

        int result = blackClient.solution(userIds, bannedIds);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        String[] userIds = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedIds = {"*rodo", "*rodo", "******"};

        int result = blackClient.solution(userIds, bannedIds);
        assertEquals(2, result);
    }

    @Test
    void test3() {
        String[] userIds = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bannedIds = {"fr*d*", "*rodo", "******", "******"};

        int result = blackClient.solution(userIds, bannedIds);
        assertEquals(3, result);
    }

}