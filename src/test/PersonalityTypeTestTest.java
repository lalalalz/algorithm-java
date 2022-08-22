package test;

import level1.PersonalityTypeTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalityTypeTestTest {

    PersonalityTypeTest personalityTypeTest = new PersonalityTypeTest();

    @Test
    void test1() {
	    String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String result = personalityTypeTest.solution(survey, choices);
        assertEquals(true, result.equals("TCMA"));
    }

}