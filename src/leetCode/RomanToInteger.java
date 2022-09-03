package leetCode;

import java.util.HashMap;

public class RomanToInteger {

    private static final int NONE = 0;
    private HashMap<String, Integer> romanNumber = new HashMap<>();

    public int romanToInt(String s) {
        setRomanNumber();
        return romanToInteger(0, s);
    }

    private void setRomanNumber() {
        romanNumber.put("I", 1);
        romanNumber.put("V", 5);
        romanNumber.put("X", 10);
        romanNumber.put("L", 50);
        romanNumber.put("C", 100);
        romanNumber.put("D", 500);
        romanNumber.put("M", 1000);
        romanNumber.put("IV", 4);
        romanNumber.put("IX", 9);
        romanNumber.put("XL", 40);
        romanNumber.put("XC", 90);
        romanNumber.put("CD", 400);
        romanNumber.put("CM", 900);
    }

    private int romanToInteger(int index, String str) {
        String source;

        if(index == str.length()) return 0;

        if (str.length() >= index + 2) {
            source = str.substring(index, index + 2);

            if(getRomanNumber(source) != NONE) {
                return getRomanNumber(source) + romanToInteger(index + 2, str);
            }
        }

        source = str.substring(index, index + 1);
        return getRomanNumber(source) + romanToInteger(index + 1, str);
    }

    private int getRomanNumber(String source) {
        return romanNumber.getOrDefault(source, NONE);
    }
}
