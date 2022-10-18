package leetCode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        return getMaxProfit(prices);
    }

    private int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        int prevStockPrice;
        int currStockPrice;

        for (int i = 1; i < prices.length; i++) {
            currStockPrice = prices[i];
            prevStockPrice = prices[i - 1];

            if (isUpperLimit(currStockPrice, prevStockPrice)) {
                maxProfit += currStockPrice - prevStockPrice;
            }
        }

        return maxProfit;
    }

    private boolean isUpperLimit(int currStockPrice, int prevStockPrice) {
        return currStockPrice >= prevStockPrice;
    }
}
