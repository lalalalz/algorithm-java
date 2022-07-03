package level1.programmers;

public class CeaserCode {

    public String solution(String s, int n) {
        String answer = "";
        char[] convertedString = s.toCharArray();

        for (int i = 0; i < convertedString.length; i++) {
            char target = convertedString[i];

            if (target >= 'a' && target <= 'z') {
                int index = ('a' - target + n) % 26;
                char newTarget = (char)(target + index);
                convertedString[i] = newTarget;
            }

            if (target >= 'A' && target <= 'Z') {
                int index = ('A' - target + n) % 26;
                char newTarget = (char)(target + index);
                convertedString[i] = newTarget;
            }
        }

        answer = convertedString.toString();
        return answer;
    }
}
