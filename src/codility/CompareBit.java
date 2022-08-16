package codility;

import java.util.Arrays;

public class CompareBit {

    private boolean[] isZero;

    public int solution(int A, int B, int C) {
        return getCountOfConformingInteger(A & B & C);
    }

    private int getCountOfConformingInteger(int composedNumber) {
        int count = 0;

        if(composedNumber == 0) return 1;

        for (int i = 1; i <= composedNumber; i*=2) {
            if ((i & composedNumber) == 0) {
                count += 2;
            }
        }

        return count;
    }
}
