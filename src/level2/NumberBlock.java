package level2;

public class NumberBlock {

    public int[] solution(long begin, long end) {
        return getNumberBlocks((int)begin, (int)end);
    }

    private int[] getNumberBlocks(int begin, int end) {
        int[] result = new int[end - begin + 1];

        for (int i = begin; i <= end; i++) {
            result[i - begin] = getLatestDivisor(i);
        }

        return result;
    }

    private int getLatestDivisor(int targetNumber) {
        int latestDivisor = 1;

        if(targetNumber == 1) return 0;

        for (int j = 2; j * j <= targetNumber; j++) {
            if (targetNumber % j == 0 && targetNumber / j <= 1000000) {
                latestDivisor = targetNumber / j;
                break;
            }
        }

        return latestDivisor;
    }
}
