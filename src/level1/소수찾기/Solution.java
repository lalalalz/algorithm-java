package level1.소수찾기;

import java.util.Arrays;

/**
 * 문제: 소수 찾기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * <p>
 * === 문제 설명 ===
 * <p>
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * <p>
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * <p>
 * (1은 소수가 아닙니다.)
 * <p>
 * 제한 조건
 * <p>
 * n은 2이상 1000000이하의 자연수입니다.
 * <p>
 * 입출력 예
 * <p>
 * n	result
 * <p>
 * 10	4
 * <p>
 * 5	3
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1
 * <p>
 * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
 * <p>
 * 입출력 예 #2
 * <p>
 * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
 */
public class Solution {

    public int solution(int n) {
        int answer = n - 1;

        // 배열 초기화
        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);

        // 에라토스테네스의 체 실행
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrimeNumber[j] = false;
                    answer--;
                }
            }
        }

        return answer;
    }
}
