package level1.정수제곱근판별;

/**
 * 문제: 정수 제곱근 판별
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12934
 * <p>
 * === 문제 설명 ===
 * <p>
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * <p>
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * <p>
 * 제한 사항
 * <p>
 * n은 1이상,  50,000,000,000,000 이하인 양의 정수입니다.
 * <p>
 * 입출력 예
 * <p>
 * n	return
 * <p>
 * 121	144
 * <p>
 * 3	-1
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예#1
 * <p>
 * 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
 * <p>
 * 입출력 예#2
 * <p>
 * 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
 */
public class Solution {

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt == Math.floor(sqrt) ? (long) Math.pow((long) sqrt + 1, 2) : -1;
    }
}
