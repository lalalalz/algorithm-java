package level1.삼진법뒤집기;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 3진법 뒤집기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * <p>
 * === 문제 설명 ===
 * <p>
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * <p>
 * n은 1 이상 100,000,000 이하인 자연수입니다.
 * <p>
 * 입출력 예
 * <p>
 * n	result
 * <p>
 * 45	7
 * <p>
 * 125	229
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1
 * <p>
 * 답을 도출하는 과정은 다음과 같습니다.
 * <p>
 * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
 * <p>
 * 45	1200	0021	7
 * <p>
 * 따라서 7을 return 해야 합니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 답을 도출하는 과정은 다음과 같습니다.
 * <p>
 * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
 * <p>
 * 125	11122	22111	229
 * <p>
 * 따라서 229를 return 해야 합니다.
 */
public class Solution {

    public int solution(int n) {
        // 나머지 구하기
        List<Integer> remainder = new ArrayList<>();
        while (n > 0) {
            remainder.add(n % 3);
            n /= 3;
        }

        // 10진수 만들기
        int answer = 0;
        int length = remainder.size() - 1;

        for (int i = 0; i < remainder.size(); i++) {
            answer += (int) (remainder.get(length - i) * Math.pow(3, i));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int solution1 = solution.solution(5);
        System.out.println("solution = " + solution1);
    }
}
