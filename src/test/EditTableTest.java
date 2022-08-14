package test;

import level3.EditTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditTableTest {

    EditTable editTable = new EditTable();

    @Test
    void test1() {
        String[] commands = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String result = editTable.solution(8, 2, commands);
        System.out.println("result = " + result);
        assertEquals(true, result.equals("OOOOXOOO"));
    }

    @Test
    void test2() {
        String[] commands = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        String result = editTable.solution(8, 2, commands);
        System.out.println("result = " + result);
        assertEquals(true, result.equals("OOXOXOOO"));
    }

}