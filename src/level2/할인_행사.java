package level2;

import java.util.HashMap;

/**
 * 1 ≤ want의 길이 = number의 길이 ≤ 10
 * 1 ≤ number의 원소 ≤ 10
 * number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
 * 10 ≤ discount의 길이 ≤ 100,000
 * want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
 * 1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
 */
public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i < discount.length - 10; i++) {
            HashMap<String, Integer> discountInfo = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                int count = discountInfo.getOrDefault(discount[j], 0);
                discountInfo.put(discount[j], count + 1);
            }

            if (isAllItemsDiscount(want, number, discountInfo)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isAllItemsDiscount(String[] want, int[] number, HashMap<String, Integer> discountInfo) {
        int count = 0;

        for (int i = 0; i < want.length; i++) {
            int numberOfDiscount = discountInfo.getOrDefault(want[i], 0);
            if (number[i] <= numberOfDiscount) {
                count++;
            }
        }

        return want.length == count;
    }
}
