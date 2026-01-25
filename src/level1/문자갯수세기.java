package level1;

import java.util.HashMap;
import java.util.Map;

public class 문자갯수세기 {

    public int[] solution(String myString) {
        Map<Character, Integer> characterCountMap = new HashMap<>();

        for (char i = 'A'; i < 'z'; i++) {
            characterCountMap.put(i, 0);
        }

        for (int i = 0; i < myString.length(); i++) {
            char character = myString.charAt(i);
            characterCountMap.put(character, characterCountMap.getOrDefault(character, 0) + 1);
        }

        return characterCountMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(Map.Entry::getValue)
                .toArray();
    }
}
