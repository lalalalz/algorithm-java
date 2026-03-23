package level1.숫자짝꿍;

public class Solution {

    public String solution(String X, String Y) {
        int[] commonNumberOfX = new int[10];
        int[] commonNumberOfY = new int[10];

        parseCommonNumber(X, commonNumberOfX);
        parseCommonNumber(Y, commonNumberOfY);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (commonNumberOfX[i] > 0 && commonNumberOfY[i] > 0) {
                int min = Math.min(commonNumberOfX[i], commonNumberOfY[i]);
                while (min-- > 0) {
                    stringBuilder.append(i);
                }
            }
        }

        String answer = stringBuilder.toString();
        return answer.isBlank()
                ? "-1"
                : answer.indexOf("0") == 0
                  ? "0"
                  : answer;
    }

    private void parseCommonNumber(String x, int[] commonNumber) {
        for (int i = 0; i < x.length(); i++) {
            int number = x.charAt(i) - '0';
            commonNumber[number]++;
        }
    }
}
