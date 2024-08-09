package level2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {

    private static final char ROBOT = 'R';
    private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static final char WALL = 'D';
    public static final boolean VISITED = true;
    public static final char GOAL = 'G';

    public static void main(String[] args) {
        리코쳇_로봇 리코쳇_로봇 = new 리코쳇_로봇();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println("리코쳇_로봇.main " + 리코쳇_로봇.solution(board));
    }

    public int solution(String[] board) {
        Coordinate robotCoordinate = findRobot(board);
        return findBestWayToGoal(board, robotCoordinate);
    }

    private int findBestWayToGoal(String[] board, Coordinate robotCoordinate) {
        int result = -1;
        boolean[][] visited = new boolean[board.length][board[0].length()];

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(robotCoordinate);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            visit(current, visited);
            if (isGoal(current, board)) {
                result = current.step;
                break;
            }

            for (int i = 0; i < 4; i++) {
                Coordinate next = move(current, board, visited, i);
                if (next != null) {
                    queue.add(next);
                }
            }
        }

        return result;
    }

    private Coordinate move(Coordinate current, String[] board, boolean[][] visited, int i) {
        Coordinate next = new Coordinate(current.y, current.x, current.step + 1);

        while (canGoNext(next, board, i)) {
            next.y += DIR[i][0];
            next.x += DIR[i][1];
        }

        if (!isFirstVisit(next, visited)) {
            return null;
        }

        return next;
    }

    private void visit(Coordinate current, boolean[][] visited) {
        visited[current.y][current.x] = VISITED;
    }

    private boolean isGoal(Coordinate current, String[] board) {
        return board[current.y].charAt(current.x) == GOAL;
    }

    private boolean canGoNext(Coordinate next, String[] board, int dir) {
        Coordinate target = new Coordinate(next.y + DIR[dir][0], next.x + DIR[dir][1], next.step);
        return isInBoard(target, board) && isEmptyPlace(target, board);
    }

    private boolean isFirstVisit(Coordinate target, boolean[][] visited) {
        return !visited[target.y][target.x];
    }

    private boolean isEmptyPlace(Coordinate target, String[] board) {
        return board[target.y].charAt(target.x) != WALL;
    }

    private static boolean isInBoard(Coordinate target, String[] board) {
        return target.y >= 0 && target.y < board.length
                && target.x >= 0 && target.x < board[0].length();
    }

    private Coordinate findRobot(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == ROBOT) {
                    return new Coordinate(i, j, 0);
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public static class Coordinate {
        int x;
        int y;
        int step;

        public Coordinate(int y, int x, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
