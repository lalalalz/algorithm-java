package level1.자연수뒤집어배열로만들기;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 자연수 뒤집어 배열로 만들기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12932
 * <p>
 * === 문제 설명 ===
 * <p>
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 * <p>
 * 제한 조건
 * <p>
 * n은 10,000,000,000이하인 자연수입니다.
 * <p>
 * 입출력 예
 * <p>
 * n	return
 * <p>
 * 12345	[5,4,3,2,1]
 */
public class Solution {

    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();

        while (n > 0) {
            answer.add((int) (n % 10));
            n /= 10;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
