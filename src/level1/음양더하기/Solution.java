package level1.음양더하기;

/**
 * 문제: 음양 더하기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * <p>
 * === 문제 설명 ===
 * <p>
 * 어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * <p>
 * absolutes의 길이는 1 이상 1,000 이하입니다.
 * <p>
 * absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
 * <p>
 * signs의 길이는 absolutes의 길이와 같습니다.
 * <p>
 * signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
 * <p>
 * 입출력 예
 * <p>
 * absolutes	signs	result
 * <p>
 * [4,7,12]	[true,false,true]	9
 * <p>
 * [1,2,3]	[false,false,true]	0
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1
 * <p>
 * signs가 [true,false,true] 이므로, 실제 수들의 값은 각각 4, -7, 12입니다.
 * <p>
 * 따라서 세 수의 합인 9를 return 해야 합니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * signs가 [false,false,true] 이므로, 실제 수들의 값은 각각 -1, -2, 3입니다.
 * <p>
 * 따라서 세 수의 합인 0을 return 해야 합니다.
 */
public class Solution {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }

        return answer;
    }
}
