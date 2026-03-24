package level1.평균구하기;

import java.util.Arrays;

/**
 * 문제: 평균 구하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12944
 * <p>
 * === 문제 설명 ===
 * <p>
 * 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
 * <p>
 * 제한사항
 * <p>
 * arr은 길이 1 이상, 100 이하인 배열입니다.
 * <p>
 * arr의 원소는  -10,000 이상 10,000 이하인 정수입니다.
 * <p>
 * 입출력 예
 * <p>
 * arr         return
 * [1,2,3,4]   2.5
 * [5,5]       5
 */
public class Solution {

    public double solution(int[] arr) {
        return Arrays
                .stream(arr)
                .average()
                .getAsDouble();
    }
}
