package level2;

public class MatrixMultiplication {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length;
        int width = arr2[0].length;
        int[][] answer = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                answer[i][j] = multiply(i, j, arr1, arr2);
            }
        }

        return answer;
    }

    private int multiply(int height, int width, int[][] arr1, int[][] arr2) {
        int result = 0;

        for (int i = 0; i < arr1[0].length; i++) {
            result += arr1[height][i] * arr2[i][width];
        }

        return result;
    }
}
