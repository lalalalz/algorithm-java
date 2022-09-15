package level3;

public class UnDestroyedBuilding {

    private int[][] sumBoard;
    private static final int ENEMY = 1;
    private static final int OURS = 2;

    public int solution(int[][] board, int[][] skills) {
        generateSumBoard(board);
        simulation(board, skills);
        return getUnDestroyedBuildingCount(board);
    }

    private void generateSumBoard(int[][] board) {
        sumBoard = new int[board.length + 1][board[0].length + 1];
    }

    private void simulation(int[][] board, int[][] skills) {
        for (int[] skill : skills) {
            int type = skill[0];

            if (type == OURS) {
                recoverBuilding(skill);
            }
            if (type == ENEMY) {
                attackBuilding(skill);
            }
        }

        calcSum(board);
    }

    private void calcSum(int[][] board) {
        for (int i = 0; i < sumBoard.length - 1; i++) {
            for (int j = 1; j < sumBoard[0].length - 1; j++) {
                sumBoard[i][j] += sumBoard[i][j - 1];
            }
        }

        for (int i = 0; i < sumBoard[0].length - 1; i++) {
            for (int j = 1; j < sumBoard.length - 1; j++) {
                sumBoard[j][i] += sumBoard[j - 1][i];
            }
        }
    }

    private void attackBuilding(int[] skill) {
        int leftY  = skill[1];
        int leftX  = skill[2];
        int rightY = skill[3];
        int rightX = skill[4];
        int degree = skill[5];

        sumBoard[leftY][leftX] += -degree;
        sumBoard[leftY][rightX + 1] += degree;
        sumBoard[rightY + 1][leftX] += degree;
        sumBoard[rightY + 1][rightX + 1] += -degree;
    }

    private void recoverBuilding(int[] skill) {
        int leftY  = skill[1];
        int leftX  = skill[2];
        int rightY = skill[3];
        int rightX = skill[4];
        int degree = skill[5];

        sumBoard[leftY][leftX] += degree;
        sumBoard[leftY][rightX + 1] += -degree;
        sumBoard[rightY + 1][leftX] += -degree;
        sumBoard[rightY + 1][rightX + 1] += degree;
    }

    private int getUnDestroyedBuildingCount(int[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (sumBoard[i][j] + board[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
