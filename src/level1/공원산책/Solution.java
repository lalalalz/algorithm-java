package level1.공원산책;

public class Solution {

    private static final int E = 0;
    private static final int W = 1;
    private static final int N = 2;
    private static final int S = 3;
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int[] solution(String[] park, String[] routes) {
        int y = 0;
        int x = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                y = i;
                x = park[i].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] commands = route.split(" ");
            String direction = commands[0];
            int length = Integer.parseInt(commands[1]);
            
            SimulationResult result = switch (direction) {
                case "E" -> doSimulation(park, E, x, y, length);
                case "W" -> doSimulation(park, W, x, y, length);
                case "N" -> doSimulation(park, N, x, y, length);
                default -> doSimulation(park, S, x, y, length);
            };

            y = result.newY;
            x = result.newX;
        }

        return new int[]{y, x};
    }

    private SimulationResult doSimulation(String[] park, int direction, int x, int y, int length) {
        int newY = y;
        int newX = x;
        boolean canMove = true;

        while (length-- > 0) {
            newY = directions[direction][0] + newY;
            newX = directions[direction][1] + newX;

            if (newY >= park.length || newY < 0 || newX >= park[0].length() || newX < 0 || park[newY].charAt(newX) == 'X') {
                canMove = false;
                break;
            }
        }

        return canMove
                ? new SimulationResult(newY, newX)
                : new SimulationResult(y, x);
    }

    public static class SimulationResult {
        int newY;
        int newX;

        public SimulationResult(int newY, int newX) {
            this.newY = newY;
            this.newX = newX;
        }
    }
}
