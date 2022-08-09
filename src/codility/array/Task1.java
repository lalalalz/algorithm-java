package codility.array;

public class Task1 {
    public int solution(int n) {
        return getLongestBinaryGap(n);
    }

    private int getLongestBinaryGap(int n) {
        int temp = 0;
        int longestBinaryGap = 0;

        String binaryString = Integer.toBinaryString(n);

        for (int i = 1; i <= binaryString.length(); i++) {
            if (binaryString.charAt(i - 1) == '1') {
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
