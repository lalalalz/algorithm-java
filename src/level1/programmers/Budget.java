package level1.programmers;

import java.util.Arrays;

public class Budget {

//    private int[][] cache = new int[101][1000001];

    public int solution(int[] d, int budget) {
        int answer = 0;

        answer = makeMaximumPurchase(d, budget);

        return answer;
    }

    private int makeMaximumPurchase(int[] itemList, int budgetSource) {
        int budget = budgetSource;
        int countsOfPurchasing = 0;

        Arrays.sort(itemList);
        for (int price : itemList) {
            if (budget - price >= 0) {
                budget -= price;
                countsOfPurchasing++;
            }
        }

        return countsOfPurchasing;
    }

//    private void init() {
//        for (int[] ints : cache) {
//            Arrays.fill(ints, -1);
//        }
//    }

//    private int makeMaximumPurchase(int departmentNumber, int[] itemList, int budget) {
//        int result = cache[departmentNumber][budget];
//
//        if(result > -1) return result;
//        if(departmentNumber >= itemList.length) return 0;
//
//        result = makeMaximumPurchase(departmentNumber + 1, itemList, budget);
//        if (budget - itemList[departmentNumber] >= 0) {
//            result = Math.max(result,
//                    makeMaximumPurchase(departmentNumber + 1, itemList,
//                            budget - itemList[departmentNumber]) + 1);
//        }
//
//        return result = cache[departmentNumber][budget];
//    }
}
