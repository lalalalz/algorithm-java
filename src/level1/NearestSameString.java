package level1;

import java.util.HashMap;

public class NearestSameString {

    public int[] solution(String s) {
        return getNearestSameString(s);
    }

    private int[] getNearestSameString(String s) {
        int[] result = new int[s.length()];
        HashMap<Character, Integer> nearestSameStringIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            result[i] = nearestSameStringIndex
                    .getOrDefault(s.charAt(i), -1);

            if (result[i] > -1) {
                result[i] = i - result[i];
            }

            nearestSameStringIndex.put(s.charAt(i), i);
        }

        return result;
    }
}
