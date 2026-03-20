package level1.크레인인형뽑기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int solution(int[][] b, int[] moves) {
        int answer = 0;
        int length = b.length;

        // 보드 준비
        List<Stack<Integer>> board = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            board.add(new Stack<>());
        }

        // 보드 초기화
        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] > 0) {
                    board.get(j).push(b[i][j]);
                }
            }
        }

        // 인형뽑기
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            if (board.get(move - 1).isEmpty()) {
                continue;
            }

            int pop = board.get(move - 1).pop();

            if (!basket.isEmpty() && basket.peek() == pop) {
                answer += 2;
                basket.pop();
            }
            else {
                basket.push(pop);
            }
        }

        return answer;
    }
}
