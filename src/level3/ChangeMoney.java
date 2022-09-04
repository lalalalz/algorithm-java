package level3;

import java.util.Arrays;

public class ChangeMoney {

    private static final int MAX = 1000000007;
    private int[][] cache = new int[100001][100];

    public int solution(int n, int[] money) {
        return getNumberOfChangeCases(n, 0, money);
    }

    private int getNumberOfChangeCases(int n, int moneyType, int[] money) {
        int numberOfChangeCases = cache[n][moneyType];

        if(n == 0) return 1;
        if(moneyType >= money.length) return 0;
        if(numberOfChangeCases > 0) return numberOfChangeCases;

        numberOfChangeCases = getNumberOfChangeCases(n, moneyType + 1, money);
        if (n - money[moneyType] >= 0) {
            numberOfChangeCases = (numberOfChangeCases +
                    getNumberOfChangeCases(n - money[moneyType], moneyType, money)) % MAX;
        }

        return cache[n][moneyType] = numberOfChangeCases;
    }
}
