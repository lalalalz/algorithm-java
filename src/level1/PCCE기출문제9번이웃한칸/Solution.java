package level1.PCCE기출문제9번이웃한칸;

/**
 * 문제: [PCCE 기출문제] 9번 / 이웃한 칸
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/250125
 * <p>
 * === 문제 설명 ===
 * <p>
 * 각 칸마다 색이 칠해진 2차원 격자 보드판이 있습니다. 그중 한 칸을 골랐을 때, 위, 아래, 왼쪽, 오른쪽 칸 중 같은 색깔로 칠해진 칸의 개수를 구하려고 합니다.
 * <p>
 * 보드의 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board와 고른 칸의 위치를 나타내는 두 정수 h, w가 주어질 때 board[h][w]와 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 return 하도록 solution 함수를 완성해 주세요.
 * <p>
 * 제한사항
 * <p>
 * 1 ≤ board의 길이 ≤ 7
 * <p>
 * board의 길이와 board[n]의 길이는 동일합니다.
 * <p>
 * 0 ≤ h, w < board의 길이
 * <p>
 * 1 ≤ board[h][w]의 길이 ≤ 10
 * <p>
 * board[h][w]는 영어 소문자로만 이루어져 있습니다.
 * <p>
 * 입출력 예
 * <p>
 * board	h	w	result
 * [["blue", "red", "orange", "red"], ["red", "red", "blue", "orange"], ["blue", "orange", "red", "red"], ["orange", "orange", "red", "blue"]]	1	1	2
 * [["yellow", "green", "blue"], ["blue", "green", "yellow"], ["yellow", "blue", "blue"]]	0	1	1
 */
public class Solution {

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 같은 색 찾기
        String color = board[h][w];
        for (int d = 0; d < 4; d++) {
            int newH = h + dir[d][0];
            int newW = w + dir[d][1];

            if (newH < 0 || newW < 0 || newH >= board.length || newW >= board[0].length) {
                continue;
            }

            if (board[newH][newW].equals(color)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
