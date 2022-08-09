package codility.array;

public class Task1 {
    public int solution(int n) {
        return getLongestBinaryGap(n);
    }

    private int getLongestBinaryGap(int n) {
        int temp = 0;
        int longestBinaryGap = 0;
        boolean isStarted = false;

        for (int i = 1; i <= n; i*=2) {
            if ((n & i) == i) {
                longestBinaryGap = longestBinaryGap > temp ? longestBinaryGap : temp;
                temp = 0;
            }

            else {
                 temp++;
            }
        }

        return longestBinaryGap;
    }
}
