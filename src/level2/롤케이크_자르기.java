package level2;

import java.util.HashSet;
import java.util.Set;

public class 롤케이크_자르기 {

    public static void main(String[] args) {
        롤케이크_자르기 롤케이크_자르기 = new 롤케이크_자르기();
        int[] toppings = {1, 2, 1, 3, 1, 4, 1, 2};
        int solution = 롤케이크_자르기.solution(toppings);
        System.out.println("solution = " + solution);
    }
    public int solution(int[] toppings) {
        int[] leftDirectionCountOfType = getLeftDirectionCountOfTypes(toppings);
        int[] rightDirectionCountOfTypes = getRightDirectionCountOfTypes(toppings);
        return getCountOfAllWaysToDivide(toppings, rightDirectionCountOfTypes, leftDirectionCountOfType);
    }

    private int getCountOfAllWaysToDivide(int[] toppings,
                                          int[] rightDirectionCountOfTypes,
                                          int[] leftDirectionCountOfType) {
        int count = 0;

        for (int i = 0; i < toppings.length - 1; i++) {
            if (rightDirectionCountOfTypes[i] == leftDirectionCountOfType[i + 1]) {
                count++;
            }
        }
        return count;
    }

    private int[] getRightDirectionCountOfTypes(int[] toppings) {
        int[] countOfTypes = new int[toppings.length];
        Set<Integer> toppingType = new HashSet<>();

        for (int i = 0; i < toppings.length; i++) {
            toppingType.add(toppings[i]);
            countOfTypes[i] = toppingType.size();
        }

        return countOfTypes;
    }

    private int[] getLeftDirectionCountOfTypes(int[] toppings) {
        int[] countOfTypes = new int[toppings.length];
        Set<Integer> toppingType = new HashSet<>();

        for (int i = toppings.length - 1; i >= 0; i--) {
            toppingType.add(toppings[i]);
            countOfTypes[i] = toppingType.size();
        }

        return countOfTypes;
    }
}
