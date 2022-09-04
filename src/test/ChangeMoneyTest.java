package test;

import level3.ChangeMoney;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeMoneyTest {

    ChangeMoney changeMoney = new ChangeMoney();

    @Test
    void test1() {
        int result = changeMoney.solution(5, new int[]{1, 2, 5});
        assertEquals(4, result);
    }

}