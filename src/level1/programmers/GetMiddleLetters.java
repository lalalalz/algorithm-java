package level1.programmers;

public class GetMiddleLetters {

    public String solution(String inputString) {
        return getMiddleLetters(inputString);
    }

    public String getMiddleLetters(String input) {
        String result = "";
        int length = input.length();

        if(length == 1) return input;

        result = input.substring((length - 1) / 2, length / 2 + 1);

        return result;
    }
}
