package level1;

public class SplitString {

    public int solution(String s) {
        int splitCount = 0;

        while (s.length() > 0) {
            s = split(s);
            splitCount++;
        }

        return splitCount;
    }

    private String split(String str) {
        int sameCount = 1;
        int nonSameCount = 0;
        char firstCharacter = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (sameCount == nonSameCount) {
                return str.substring(i);
            }

            if (str.charAt(i) == firstCharacter) {
                sameCount++;
            }

            else {
                nonSameCount++;
            }
        }

        return "";
    }
}
