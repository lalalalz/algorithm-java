package level2;

public class BiggestSquare {

//    private int[][] board;
//    private int[][] maxSquareSideLength;
//    private int boardWidth;
//    private int boardHeight;

//    public int solution(int [][]b) {
//        return getBiggestSquare(b);
//    }
//
//    public int max(int a, int b) {
//        return a > b ? a : b;
//    }
//
//    public int min(int a, int b) {
//        return a > b ? b : a;
//    }
//
//    private int getBiggestSquare(int[][] b) {
//        int maxLength = 0;
//
//        board = b;
//        boardHeight = board.length;
//        boardWidth = board[0].length;
//        maxSquareSideLength = new int[boardHeight][boardWidth];
//
//        for (int i = 0; i < boardHeight; i++) {
//            for (int j = 0; j < boardWidth; j++) {
//                maxSquareSideLength[i][j] = -1;
//            }
//        }
//
//        setMaxSquareSideLength(boardHeight - 1, boardWidth - 1);
//
//        for (int i = 0; i < boardHeight; i++) {
//            for (int j = 0; j < boardWidth; j++) {
//                maxLength = max(maxLength, maxSquareSideLength[i][j]);
//            }
//        }
//
//        return maxLength * maxLength;
//    }
//
//    private int setMaxSquareSideLength(int y, int x) {
//        int minimal = 1001;
//
//        if(maxSquareSideLength[y][x] > -1) return maxSquareSideLength[y][x];
//
//        if (isIncluded(y, x) == true) {
//            minimal = min(minimal, setMaxSquareSideLength(y - 1, x));
//            minimal = min(minimal, setMaxSquareSideLength(y, x - 1));
//            minimal = min(minimal, setMaxSquareSideLength(y - 1, x - 1));
//
//            if(minimal == 0 || board[y][x] == 0) return maxSquareSideLength[y][x] = board[y][x];
//            return maxSquareSideLength[y][x] = minimal + 1;
//        }
//
//        return maxSquareSideLength[y][x] = board[y][x];
//    }
//
//    private boolean isIncluded(int y, int x) {
//        int[][] dir = {{0, -1}, {-1, 0}, {-1, -1}};
//
//        for (int i = 0; i < 3; i++) {
//            int newY = y + dir[i][0];
//            int newX = x + dir[i][1];
//
//            if (newY >= boardHeight || newY < 0
//                    || newX >= boardWidth || newX < 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public int solution(int[][] board) {
        int width = board[0].length;
        int height = board.length;
        int maxLength = 0;

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1]) + 1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maxLength = Math.max(maxLength, board[i][j]);
            }
        }

        return maxLength * maxLength;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
//    private int getBiggestSquare(int[][] board) {
//        int biggestArea = 0;
//        int biggestSideLength = board.length > board[0].length ? board[0].length : board.length;
//
//        for (int sideLength = biggestSideLength; sideLength >= 1; sideLength--) {
//            if (hasSquare(sideLength, board)) {
//                biggestArea = sideLength * sideLength;
//                break;
//            }
//        }
//
//        return biggestArea;
//    }
//
//    private boolean hasSquare(int sideLength, int[][] board) {
//        boolean result = false;
//
//        for (int y = 0; y <= board.length - sideLength; y++) {
//            for (int x = 0; x <= board[0].length - sideLength ; x++) {
//                if (isSquare(y, x, sideLength, board)) {
//                    result = true;
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private boolean isSquare(int y, int x, int sideLength, int[][] board) {
//        boolean isSquare = true;
//
//        for (int i = y; i < y + sideLength; i++) {
//            for (int j = x; j < x + sideLength; j++) {
//                if (board[i][j] != 1) {
//                    isSquare = false;
//                    break;
//                }
//            }
//        }
//
//        return isSquare;
//    }
}
