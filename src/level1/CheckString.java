package level1;

public class CheckString {
    public boolean solution(String s) {
        return hasSpecificLength(s) && hasOnlyNumber(s);
    }

    private boolean hasSpecificLength(String str) {
        return str.length() == 4 || str.length() == 6;
    }

    private boolean hasOnlyNumber(String str) {
        return str.length() == str.chars()
                .filter(s -> Character.isDigit(s))
                .count();
    }
}
