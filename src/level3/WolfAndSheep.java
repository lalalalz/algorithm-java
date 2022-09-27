package level3;

public class WolfAndSheep {

    private static final int SHEEP = 0;
    private static final int UNCONNECTED = 0;

    private SheepAndWolves[][][] cache = new SheepAndWolves[18][18][18];
    private int[][] connection = new int[18][2];

    public int solution(int[] info, int[][] edges) {
        generateConnectionInfo(edges);
        SheepAndWolves maxSheepCount = getMaxSheepCount(1, 0, 0, info);
        return maxSheepCount.getSheep();
    }

    private void generateConnectionInfo(int[][] edges) {
        for (int[] edge : edges) {
            int parent = edge[0] + 1;
            int child  = edge[1] + 1;

            if (connection[parent][0] == UNCONNECTED) {
                connection[parent][0] = child;
            }
            else {
                connection[parent][1] = child;
            }
        }
    }

    private SheepAndWolves getMaxSheepCount(int root, int sheep, int wolves, int[] info) {
        int leftChild  = connection[root][0];
        int rightChild = connection[root][1];
        SheepAndWolves result = new SheepAndWolves(sheep, wolves);

        if(root == UNCONNECTED) {
            return new SheepAndWolves(0, 0);
        }
        if (sheep < wolves) {
            return new SheepAndWolves(0, 0);
        }

        SheepAndWolves leftRightCircuitResult = leftRightCircuit(leftChild, rightChild, sheep, wolves, info);
        SheepAndWolves rightLeftCircuitResult = rightLeftCircuit(rightChild, leftChild, sheep, wolves, info);

//        if (leftRightCircuitResult.getSheep() > rightLeftCircuitResult.getSheep()) {
//            result.merge(leftRightCircuitResult);
//        }
//        else {
//            result.merge(rightLeftCircuitResult);
//        }

        return info[root - 1] == SHEEP ? result.addSheep(1) : result.addWolves(1);
    }

    private SheepAndWolves leftRightCircuit(int leftChild, int rightChild, int sheep, int wolves, int[] info) {
        SheepAndWolves leftCircuitResult = getMaxSheepCount(leftChild, sheep, wolves, info);
        return getMaxSheepCount(rightChild, sheep + leftCircuitResult.getSheep(),
                wolves + leftCircuitResult.getWolves(), info);
    }

    private SheepAndWolves rightLeftCircuit(int rightChild, int leftChild, int sheep, int wolves, int[] info) {
        SheepAndWolves rightCircuitResult = getMaxSheepCount(rightChild, sheep, wolves, info);
        return getMaxSheepCount(leftChild, sheep + rightCircuitResult.getSheep(),
                wolves + rightCircuitResult.getWolves(), info);
    }

    static class SheepAndWolves {
        int sheep;
        int wolves;

        public int getSheep() {
            return sheep;
        }

        public int getWolves() {
            return wolves;
        }

        public SheepAndWolves addSheep(int count) {
            sheep += count;
            return this;
        }

        public SheepAndWolves addWolves(int count) {
            wolves += count;
            return this;
        }

        public SheepAndWolves(int sheep, int wolves) {
            this.sheep = sheep;
            this.wolves = wolves;
        }

        public void merge(SheepAndWolves target) {
            sheep += target.getSheep();
            wolves += target.getWolves();
        }
    }
}