package leetCode;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = splitWord(s);
        return getLengthOfWord(split[split.length - 1]);
    }

    private String[] splitWord(String s) {
        return s.split(" ");
    }

    private int getLengthOfWord(String s) {
        return s.length();
    }
}
