package level2;

import java.util.Arrays;

public class HIndex {

    public int solution(int[] citations) {
        return getHIndex(citations);
    }

    private int getHIndex(int[] citations) {
        int hIndex = Arrays.stream(citations)
                .max()
                .getAsInt();

        while (true) {
            if(isHIndex(hIndex, citations)){
                break;
            }

            hIndex--;
        }

        return hIndex;
    }

    private boolean isHIndex(int hIndex, int[] citations) {
        int quoted = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= hIndex) {
                quoted++;
            }
        }

        return quoted >= hIndex;
    }
}
