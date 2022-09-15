package level2;

public class BestSet {

    public int[] solution(int n, int s) {
        return getBestSet(n, s);
    }

    private int[] getBestSet(int n, int s) {
        int quotient  = s / n;
        int remainder = s % n;

        return generateBestSet(n, quotient, remainder);
    }

    private int[] generateBestSet(int n, int quotient, int remainder) {
        int[] bestSet = new int[n];

        if (quotient == 0) {
            return new int[]{-1};
        }

        for (int i = bestSet.length - 1; i >= 0; i--) {
            bestSet[i] = quotient;

            if (remainder > 0) {
                bestSet[i] += 1;
                remainder--;
            }
        }

        return bestSet;
    }
}