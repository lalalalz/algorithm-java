package level1.programmers;

import java.util.stream.Stream;

public class NumberOfPandY {

    public boolean solution(String str) {
        int countsOfP = 0;
        int countsOfY = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'p' || str.charAt(i) == 'P') {
                countsOfP++;
            }
            if (str.charAt(i) == 'y' || str.charAt(i) == 'Y') {
                countsOfY++;
            }
        }

        return countsOfP == countsOfY;
    }
}
