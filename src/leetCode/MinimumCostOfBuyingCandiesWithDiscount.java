package leetCode;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        return getMinimumCost(cost);
    }

    private int getMinimumCost(int[] cost) {
        int minimumCost = 0;
        int[] sortedCost = sort(cost);

        for (int i = 0; i < sortedCost.length; ++i) {
            if (i % 3 < 2) {
                minimumCost += sortedCost[i];
            }
        }

        return minimumCost;
    }

    private int[] sort(int[] sro) {
        return Arrays.stream(sro)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
