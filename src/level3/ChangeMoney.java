package level3;

public class ChangeMoney {

    private static final int MAX = 1000000007;
    private int[][] cache = new int[100001][100];

    public int solution(int n, int[] money) {
        return getNumberOfChangeCases(n, 0, money);
    }

    private int getNumberOfChangeCases(int n, int prevMoney, int[] money) {
        int numberOfChangeCases = cache[n][prevMoney];

        if(n == 0) return 1;
        if(numberOfChangeCases > 0) return numberOfChangeCases;

        for (int i = prevMoney; i < money.length; i++) {
            if (n - money[i] >= 0) {
                numberOfChangeCases = (numberOfChangeCases +
                        getNumberOfChangeCases(n - money[i], i, money)) % MAX;
            }
        }

        return cache[n][prevMoney] = numberOfChangeCases;
    }
}
