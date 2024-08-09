package level2;

/**
 * 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
 * 이모티콘 판매액을 최대한 늘리는 것.
 * 1번 목표가 우선이며, 2번 목표가 그 다음입니다.
 *
 * n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
 * 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
 * 카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.
 *
 * 각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
 * 각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
 * 다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.
 *
 *
 * 카카오톡 사용자 n명의 구매 기준을 담은 2차원 정수 배열 users, 이모티콘 m개의 정가를 담은 1차원 정수 배열 emoticons가 주어집니다.
 * 이때, 행사 목적을 최대한으로 달성했을 때의 이모티콘 플러스 서비스 가입 수와
 * 이모티콘 매출액을 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */
public class 이모티콘_할인행사 {

    private int[][] USERS;
    private int[] EMOTICONS;
    private int MAX_SUBSCRIBERS;
    private int MAX_COST;

    public static void main(String[] args) {
        int[][] user = {{40, 10000}, {25, 10000}};
        int[] emoticonst = {7000, 9000};

        이모티콘_할인행사 이모티콘_할인행사 = new 이모티콘_할인행사();
        int[] solution = 이모티콘_할인행사.solution(user, emoticonst);

        System.out.println("solution = " + solution[0] + solution[1]);
        int i = solution[0];
    }

    public int[] solution(int[][] users, int[] emoticons) {
        USERS = users;
        EMOTICONS = emoticons;

        Profit profit = calcMaximumProfit(0, new int[emoticons.length]);
        return new int[]{profit.subscribers, profit.cost};
    }

    public Profit calcMaximumProfit(int index, int[] discount) {
        Profit maxProfit = new Profit();

        if (index == EMOTICONS.length) {
            return calcProfit(discount);
        }

        for (int discountPercentage = 10; discountPercentage <= 40; discountPercentage+=10) {
            discount[index] = discountPercentage;
            Profit profit = calcMaximumProfit(index + 1, discount);
            maxProfit = maxProfit.compareTo(profit) > 0 ? maxProfit : profit;
        }

        return maxProfit;
    }

    private Profit calcProfit(int[] discounts) {
        Profit profit = new Profit();

        for (int[] user : USERS) {
            int cost = 0;
            int minimumDiscount = user[0];
            int maximumCost = user[1];

            for (int i = 0; i < discounts.length; i++) {
                if (minimumDiscount <= discounts[i]) {
                    cost += EMOTICONS[i] * (100 - discounts[i]) / 100;
                }
            }

            if (cost >= maximumCost) {
                profit.subscribers++;
            }
            else {
                profit.cost += cost;
            }
        }

        return profit;
    }

    public static class Profit implements Comparable<Profit> {
        private int subscribers;
        private int cost;

        @Override
        public int compareTo(Profit profit) {
            if (subscribers > profit.subscribers) {
                return 1;
            }
            if (subscribers < profit.subscribers) {
                return -1;
            }

            return Integer.compare(cost, profit.cost);
        }
    }
}
