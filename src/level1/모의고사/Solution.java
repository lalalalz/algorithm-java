package level1.모의고사;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제: 모의고사
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * <p>
 * === 문제 설명 ===
 * <p>
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * <p>
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * <p>
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * <p>
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * <p>
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 조건
 * <p>
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * <p>
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * <p>
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * <p>
 * 입출력 예
 * <p>
 * answers	return
 * <p>
 * [1,2,3,4,5]	[1]
 * <p>
 * [1,3,2,4,2]	[1,2,3]
 * <p>
 * 입출력 예 설명
 * <p>
 * 입출력 예 #1
 * <p>
 * 수포자 1은 모든 문제를 맞혔습니다.
 * <p>
 * 수포자 2는 모든 문제를 틀렸습니다.
 * <p>
 * 수포자 3은 모든 문제를 틀렸습니다.
 * <p>
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 * <p>
 * 입출력 예 #2
 * <p>
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class Solution {

    public int[] solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 수포자의 맞은 개수를 구한다.
        int max = 0;
        int[] correctCount = new int[3];
        for (int i = 0; i < answers.length; i++) {
            correctCount[0] += a[i % a.length] == answers[i] ? 1 : 0;
            correctCount[1] += b[i % b.length] == answers[i] ? 1 : 0;
            correctCount[2] += c[i % c.length] == answers[i] ? 1 : 0;

            max = Math.max(max, correctCount[0]);
            max = Math.max(max, correctCount[1]);
            max = Math.max(max, correctCount[2]);
        }

        // 수포자 중 최대 점수를 받은 사람을 구한다.
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < correctCount.length; i++) {
            if (correctCount[i] == max) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }
}
