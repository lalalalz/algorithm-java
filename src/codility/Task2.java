package codility;

public class Task2 {
    public int solution(String binary) {
        return getPerformedCountUntilZero(Long.parseUnsignedLong(binary, 2));
    }

    private int getPerformedCountUntilZero(long number) {
         int count = 0;

        while (number > 0) {
            if (number % 2 == 0) {
                number /= 2;
            }
            else {
                number -= 1;
            }
            count++;
        }

        return count;
    }
}
