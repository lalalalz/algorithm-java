package leetCode.p17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private HashSet<String> result = new HashSet<>();
    private String[][] digitsToLetters = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        combinate(0, "", digits);
        return result.stream().toList();
    }

    private void combinate(int index, String combination, String digits) {
        if (index >= digits.length()) {
            result.add(combination);
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < digitsToLetters[digit - 1].length; ++i) {
            combinate(index + 1, combination + digitsToLetters[digit - 1][i], digits);
        }
    }
}
