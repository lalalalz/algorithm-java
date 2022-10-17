package leetCode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        return getMaxProfit(prices);
    }

    private int getMaxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (isUpperLimit(prices, i)) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    private boolean isUpperLimit(int[] prices, int i) {
        return prices[i] >= prices[i - 1];
    }
}
