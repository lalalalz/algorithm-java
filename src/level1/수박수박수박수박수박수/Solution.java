package level1.수박수박수박수박수박수;

/**
 * 문제: 수박수박수박수박수박수?
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12922
 *
 * === 문제 설명 ===
 *
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 *
 * 제한 조건
 *
 * n은 길이 10,000이하인 자연수입니다.
 *
 * 입출력 예
 *
 * n	return
 *
 * 3	"수박수"
 *
 * 4	"수박수박"
 */
public class Solution {

    public String solution(int n) {
        int repeat = n / 2;
        boolean isOdd = n % 2 > 0;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            answer.append("수박");
        }

        if (isOdd) {
            answer.append("수");
        }

        return answer.toString();
    }

    public static void main(String[] args) {

    }
}
