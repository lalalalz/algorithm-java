package level1;

public class 문자열여러번뒤집기 {
    public String solution(String string, int[][] queries) {
        StringBuilder answer = new StringBuilder(string);

        for (int[] query : queries) {
            int left = query[0] - 1;
            int right = query[1] - 1;

            while (left < right) {
                String leftString = answer.substring(left, left + 1);
                String rightString = answer.substring(right, right + 1);
                String temp = leftString;

                answer.replace(left, left, rightString);
                answer.replace(right, right, temp);

                left++;
                right--;
            }
        }

        return answer.toString();
    }
}
