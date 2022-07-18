package level1;

public class MakeStrangeString {

    public String solution(String s) {
        return makeStrangeString(s);
    }

    private String makeStrangeString(String str) {
        char[] chars = str.toCharArray();
        boolean isOddNumber = true;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                isOddNumber = true;
                continue;
            }

            if (isOddNumber) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            else {
                chars[i] = Character.toLowerCase(chars[i]);
            }

            isOddNumber = !isOddNumber;
        }

        return String.valueOf(chars);
    }
}
