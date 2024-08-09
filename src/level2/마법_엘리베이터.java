package level2;

public class 마법_엘리베이터 {

    public static void main(String[] args) {
        마법_엘리베이터 마법_엘리베이터 = new 마법_엘리베이터();
        int solution = 마법_엘리베이터.solution(999);
        System.out.println("solution = " + solution);
    }
    public int solution(int storey) {
        return getMinimumStepCount(storey, false);
    }

    private int getMinimumStepCount(int storey, boolean hasRoundNumber) {
        int result = 9 * 6;
        int remainder = storey % 10;

        if (hasRoundNumber) {
            remainder++;
        }
        if (storey == 0) {
            return hasRoundNumber ? 1 : 0;
        }

        if (remainder == 10) {
            result = Math.min(result, getMinimumStepCount(storey / 10, true));
        }
        else {
            // 올림
            result = Math.min(result, getMinimumStepCount(storey / 10, true) + (10 - remainder));
            // 내림
            result = Math.min(result, getMinimumStepCount(storey / 10, false) + (remainder));
        }

        return result;
    }
}
