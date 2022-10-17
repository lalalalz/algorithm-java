package leetCode;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (!hasUniqueCompleteCircuit(gas, cost)) {
            return -1;
        }

        return getStartPositionOfCompleteCircuit(gas, cost);
    }

    private int getStartPositionOfCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return start;
    }

    private boolean hasUniqueCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }

        return total >= 0;
    }
}
