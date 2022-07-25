package level2;

public class NextBigNumber {

    private final int MAX = 1000000;

    public int solution(int n) {
        return getNextBigNumber(n);
    }

    private int getNextBigNumber(int number) {
        int nextBigNumber = 0;
        long oneCountOfNumber = getCountOfOne(number);

        for (int i = number + 1; i <= 2 * MAX ; i++) {
            long oneCountOfNextBigNumber = getCountOfOne(i);

            if (oneCountOfNumber == oneCountOfNextBigNumber) {
                nextBigNumber = i;
                break;
            }
        }

        return nextBigNumber;
    }

    private long getCountOfOne(int number) {
        return Integer.bitCount(number);
//        int count = 0;
//        int mask = 1;
//
//        while (mask <= number) {
//            if ((mask & number) == mask) {
//                count++;
//            }
//
//            mask = (mask << 1);
//        }
//
//        return count;
    }
}
