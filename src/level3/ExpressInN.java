package level3;

import java.util.*;

public class ExpressInN {

    public int solution(int n, int number) {
        return getMinimumOperation(n, number);
    }

    private int getMinimumOperation(int n, int number) {
        int minimumOperation = 0;
        Set<Integer>[] minimumOperationArray = new HashSet[9];

        for (int i = 1; i <= 8; i++) {
            minimumOperationArray[i] = new HashSet<>();
            minimumOperationArray[i].
                    add(getRepetitionNumber(n, i));
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer numberA : minimumOperationArray[j]) {
                    for (Integer numberB : minimumOperationArray[i - j]) {
                        minimumOperationArray[i].add(numberA + numberB);
                        minimumOperationArray[i].add(numberA - numberB);
                        minimumOperationArray[i].add(numberA * numberB);

                        if (numberB > 0) {
                            minimumOperationArray[i].add(numberA / numberB);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= 8; i++) {
            if (minimumOperationArray[i].contains(number)) {
                minimumOperation = i;
                break;
            }
        }

        return minimumOperation > 0 ? minimumOperation : -1;
    }

    private int getRepetitionNumber(int n, int repeatCount) {
        int repetitionNumber = 0;

        while (repeatCount > 0) {
            repetitionNumber = repetitionNumber * 10 + n;
            repeatCount--;
        }

        return repetitionNumber;
    }
}