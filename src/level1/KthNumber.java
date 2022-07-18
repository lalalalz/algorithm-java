package level1;


import java.util.Arrays;

public class KthNumber {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        KthNumber kthNumber = new KthNumber();
        kthNumber.solution(array, commands);

    }

    public int[] solution(int[] array, int[][] commands) {

        int countOfProblems = commands.length;
        int[] answer = new int[countOfProblems];

        for (int i = 0; i < countOfProblems; i++) {

            int newArray[] = copyArray(array, commands[i][0] - 1, commands[i][1]);

            sortArray(newArray);
            answer[i] = findKthNumber(newArray, commands[i][2] - 1);
        }

        return answer;
    }

    private int findKthNumber(int[] array, int k) {
        return array[k];
    }

    private void sortArray(int[] copyArray) {
        Arrays.sort(copyArray);
    }

    private int[] copyArray(int[] array, int start, int end) {
        return Arrays.copyOfRange(array, start, end);
    }
}
