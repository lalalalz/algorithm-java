package level1.키패드누르기;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String right = solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
        System.out.println("right = " + right);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        // hand 초기화
        hand = hand.equals("left") ? "L" : "R";

        // 왼손, 오른손 위치
        int[] leftHandPos = {3, 0};
        int[] rightHandPos = {3, 2};

        // 각 번호를 최소거리로 누른다
        for (int number : numbers) {
            switch (number) {
                case 1, 4, 7 -> {
                    answer.append("L");
                    setHandPosition(number, leftHandPos);
                }
                case 3, 6, 9 -> {
                    answer.append("R");
                    setHandPosition(number, rightHandPos);
                }
                case 2, 5, 8, 0 -> {
                    String shortest = getShortestHand(number, hand, leftHandPos, rightHandPos);
                    answer.append(shortest);
                    setHandPosition(number, shortest.equals("L") ? leftHandPos : rightHandPos);
                }
            }
        }

        return answer.toString();
    }

    private String getShortestHand(int number, String hand, int[] leftHandPos, int[] rightHandPos) {
        int y = 3;
        int x = 1;

        if (number > 0) {
            y = (number - 1) / 3;
            x = (number - 1) % 3;
        }

        int leftHandDistance = Math.abs(leftHandPos[0] - y) + Math.abs(leftHandPos[1] - x);
        int rightHandDistance = Math.abs(rightHandPos[0] - y) + Math.abs(rightHandPos[1] - x);

        return leftHandDistance == rightHandDistance ? hand
                : leftHandDistance < rightHandDistance ? "L" : "R";
    }

    private static void setHandPosition(int number, int[] handPos) {
        if (number == 0) {
            handPos[0] = 3;
            handPos[1] = 2;
        }
        else {
            handPos[0] = (number - 1) / 3;
            handPos[1] = (number - 1) % 3;
        }
    }
}
