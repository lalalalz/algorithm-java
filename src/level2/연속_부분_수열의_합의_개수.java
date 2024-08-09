package level2;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열의_합의_개수 {

    private Set<Integer> SUM = new HashSet<>();
    private int[] SUMOFSEQUENCE = new int[1001];

    public static void main(String[] args) {
        연속_부분_수열의_합의_개수 연속_부분_수열의_합의_개수 = new 연속_부분_수열의_합의_개수();
        int[] elements = {7, 9, 1, 1, 4};

        int solution = 연속_부분_수열의_합의_개수.solution(elements);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] elements) {
        for (int i = 1; i <= elements.length; i++) {
            SUMOFSEQUENCE[i] = SUMOFSEQUENCE[i - 1] + elements[i - 1];
        }

        // 모든 부분 수열을 구한다.
        for (int start = 1; start <= elements.length; start++) {
            for (int end = start; end < start + elements.length; end++) {
                SUM.add(getSumOfSubSequence(start, end, elements.length));
            }
        }

        return SUM.size();
    }

    private int getSumOfSubSequence(int start, int end, int elementsSize) {
        int sum = 0;

        if (end > elementsSize) {
            sum = SUMOFSEQUENCE[elementsSize] - (SUMOFSEQUENCE[start - 1] - SUMOFSEQUENCE[end % elementsSize]);
        }
        else {
            sum = SUMOFSEQUENCE[end] - SUMOFSEQUENCE[start - 1];
        }

        return sum;
    }
}
