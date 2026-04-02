package level1.약수의개수와덧셈;

/**
 * 문제: 약수의 개수와 덧셈
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * <p>
 * === 문제 설명 ===
 * <p>
 * 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * <p>
 * 1 ≤ left ≤ right ≤ 1,000
 * <p>
 * 입출력 예
 * <p>
 * left	right	result
 * <p>
 * 13	17	43
 * <p>
 * 24	27	52
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1
 * <p>
 * 다음 표는 13부터 17까지의 수들의 약수를 모두 나타낸 것입니다.
 * <p>
 * 수	약수	약수의 개수
 * <p>
 * 13	1, 13	2
 * <p>
 * 14	1, 2, 7, 14	4
 * <p>
 * 15	1, 3, 5, 15	4
 * <p>
 * 16	1, 2, 4, 8, 16	5
 * <p>
 * 17	1, 17	2
 * <p>
 * 따라서, 13 + 14 + 15 - 16 + 17 = 43을 return 해야 합니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 다음 표는 24부터 27까지의 수들의 약수를 모두 나타낸 것입니다.
 * <p>
 * 수	약수	약수의 개수
 * <p>
 * 24	1, 2, 3, 4, 6, 8, 12, 24	8
 * <p>
 * 25	1, 5, 25	3
 * <p>
 * 26	1, 2, 13, 26	4
 * <p>
 * 27	1, 3, 9, 27	4
 * <p>
 * 따라서, 24 - 25 + 26 + 27 = 52를 return 해야 합니다.
 */
public class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (getCountOfFactor(i) % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }

        return answer;
    }

    private int getCountOfFactor(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                count += (i * i == number ? 1 : 2);
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
