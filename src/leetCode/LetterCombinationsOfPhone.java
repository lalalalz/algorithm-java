package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCombinationsOfPhone {

    Set<String> combinations = new HashSet<>();
    String[][] letters = {{"a","b","c"}, {"d","e","f"}, {"g","h","i"}, {"j","k","l"},
                        {"m","n","o"}, {"p","q","r","s"}, {"t","u","v"}, {"w","x","y","z"}};


    public List<String> letterCombinations(String digits) {
        findStringOfLetterCombination(0, "", digits.toCharArray());
        return combinations.stream()
                .toList();
    }

    private void findStringOfLetterCombination(int position, String combination, char[] digits) {
        if (position == digits.length) {
            if (!combination.equals("")) {
                combinations.add(combination);
            }
            return;
        }

        int dialNumber = digits[position] - '0';
        combine(position, combination, digits, dialNumber);
    }

    private void combine(int position, String combination, char[] digits, int dialNumber) {
        if(dialNumber == 1) {
            findStringOfLetterCombination(position + 1, combination, digits);
            return;
        }

        for (int i = 0; i < letters[dialNumber - 2].length; i++) {
            findStringOfLetterCombination(position + 1,
                    combination + letters[dialNumber - 2][i], digits);
        }
    }
}
