package leetCode.p43;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String multiply = solution.multiply("2", "3");
        System.out.println("multiply = " + multiply);
    }

    public String multiply(String num1, String num2) {
        Map<String, String> multiplicationTable = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiplicationTable.put("" + i + j, "0" + i * j);
            }
        }

        int answer = 0;
        int sum = 0;
        int round = 0;

        String targetNum = num1.length() > num2.length() ? num1 : num2;
        String num = num1.length() > num2.length() ? num2 : num1;

        StringBuilder reversedNum1 = new StringBuilder(targetNum).reverse();
        StringBuilder reversedNum2 = new StringBuilder(num).reverse();

        for (int i = 0; i < reversedNum1.length(); i++) {
            sum = 0;
            round = 0;

            for (int j = 0; j < reversedNum1.length(); j++) {
                String multiplication = multiplicationTable
                        .getOrDefault("" + reversedNum2.charAt(i) + reversedNum1.charAt(j), "0");

                sum += round + (multiplication.charAt(multiplication.length() - 1) - '0') * (int) (Math.pow(10, j));
                round = (multiplication.charAt(multiplication.length() - 2) - '0') * (int) (Math.pow(10, j + 1));
            }

            answer += (sum + round) * (int) Math.pow(10, (i));
        }

        return String.valueOf(answer);
    }
}
