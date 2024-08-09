package level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 2 ≤ weights의 길이 ≤ 100,000
 * 100 ≤ weights[i] ≤ 1,000
 * 몸무게 단위는 N(뉴턴)으로 주어집니다.
 * 몸무게는 모두 정수입니다.
 */
public class 시소_짝꿍 {

    double[] ratio = {1, 2, (double) 3 / 2, (double) 4 / 3};
    long[] countOfWeight = new long[1000 * 4 + 1];
    Set<Integer> weightsSet = new HashSet<>();

    public long solution(int[] weights) {
        long answer = 0;

        for (int weight : weights) {
            countOfWeight[weight]++;
            weightsSet.add(weight);
        }

        for (Integer weight : weightsSet) {
            for (int i = 0; i < 4; i++) {
                double pairWeight = weight * ratio[i];

                if (!isInteger(pairWeight)) {
                    continue;
                }

                if (weight == pairWeight) {
                    answer += countOfWeight[(int) pairWeight] * (countOfWeight[(int) pairWeight] - 1) / 2;
                }
                else {
                    answer += countOfWeight[weight] * countOfWeight[(int) pairWeight];
                }
            }
        }

        return answer;
    }

    private boolean isInteger(double value) {
        return value == (int) value;
    }
}
