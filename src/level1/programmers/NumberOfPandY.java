package level1.programmers;

public class NumberOfPandY {

    public boolean solution(String str) {
        long countsOfP = str.chars()
                .filter((ch) -> ch == 'p' || ch == 'P')
                .count();

        long countsOfY = str.chars()
                .filter((ch) -> ch == 'y' || ch == 'Y')
                .count();

        return countsOfP == countsOfY;
    }
}
