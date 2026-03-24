package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import temp.AlphabetSorting;

class AlphabetSortingTest {

    AlphabetSorting alphabetSorting = new AlphabetSorting();

    @Test
    void sort() {
        String result = alphabetSorting.solution("Zbcdefg");
        Assertions.assertEquals("gfedcbZ", result);
    }
}