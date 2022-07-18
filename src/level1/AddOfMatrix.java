package level1;

public class AddOfMatrix {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int matrixHeight = arr1.length;
        int matrixWidth = arr1[0].length;
        int[][] answer = new int[matrixHeight][matrixWidth];

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
