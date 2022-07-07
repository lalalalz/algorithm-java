package test;

import level1.programmers.AlphabetSorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetSortingTest {

    AlphabetSorting alphabetSorting = new AlphabetSorting();

    @Test
    void sort() {
        String result = alphabetSorting.solution("Zbcdefg");
        Assertions.assertEquals("gfedcbZ", result);
    }
}