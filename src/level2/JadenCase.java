package level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase {

    public String solution(String s) {
        return convertToJadenCase(s);
    }

    private String convertToJadenCase(String input) {
        char[] charArray = input.toLowerCase().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i == 0 || (i > 0 && charArray[i - 1] == ' ')) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        return String.valueOf(charArray);
    }

    private String makeJadenCase(String input) {
        String result = Arrays.stream(input.split(" "))
                .map((str) -> str = jadenCase(str))
                .collect(Collectors.joining(" "));

        if (input.charAt(input.length() - 1) == ' ') {
            result += " ";
        }

        return result;
    }

    private String jadenCase(String str) {
        System.out.println("str = " + str);
        if(str.isBlank()) return str;

        StringBuilder stringBuilder = new StringBuilder(str.toLowerCase());
        String firstString = stringBuilder.substring(0, 1);

        if (Character.isAlphabetic(firstString.charAt(0))) {
            stringBuilder.replace(0, 1, firstString.toUpperCase());
        }

        return stringBuilder.toString();
    }
}
