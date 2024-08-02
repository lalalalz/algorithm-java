package level2;

import java.util.Arrays;

public class 숫자_변환하기 {

    private static final int MAX = 1_000_000;
    private int[] convertMinimumCount = new int[MAX + 1];

    public static void main(String[] args) {
        숫자_변환하기 숫자_변환하기 = new 숫자_변환하기();
        숫자_변환하기.solution(2, 5, 4);
    }
    public int solution(int x, int y, int n) {
        return calcConvertMinimumCount(x, y, n);
    }


    private int calcConvertMinimumCount(int x, int y, int n) {
        Arrays.fill(convertMinimumCount, MAX);

        convertMinimumCount[x] = 0;
        for (int i = x; i <= y; i++) {
            if (i * 3 <= y) {
                convertMinimumCount[i * 3] = Math.min(convertMinimumCount[i * 3], convertMinimumCount[i] + 1);
            }
            if (i * 2 <= y) {
                convertMinimumCount[i * 2] = Math.min(convertMinimumCount[i * 2], convertMinimumCount[i] + 1);
            }
            if (i + n <= y) {
                convertMinimumCount[i + n] = Math.min(convertMinimumCount[i + n], convertMinimumCount[i] + 1);
            }
        }

        return convertMinimumCount[y] == MAX ?
                -1 : convertMinimumCount[y];
    }


    /**
     * 프로그래머스에서 런타임 오류, 재귀 호출 깊이가 특정 제한을 넘어가서 발생하는 것으로 추정.
     */
//    private int calcConvertMinimumCount(int x, int y, int n) {
//        int result = MAX;
//
//        if (y == x) {
//            return 0;
//        }
//        if (y < x) {
//            return MAX;
//        }
//        if (convertMinimumCount[x] > 0) {
//            return convertMinimumCount[x];
//        }
//
//        result = Math.min(result, calcConvertMinimumCount(x * 3, y, n) + 1);
//        result = Math.min(result, calcConvertMinimumCount(x * 2, y, n) + 1);
//        result = Math.min(result, calcConvertMinimumCount(x + n, y, n) + 1);
//
//        convertMinimumCount[x] = result;
//        return result;
//    }
}
