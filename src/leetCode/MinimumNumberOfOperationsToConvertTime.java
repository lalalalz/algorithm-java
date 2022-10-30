package leetCode;

public class MinimumNumberOfOperationsToConvertTime {

    public int convertTime(String current, String correct) {
        int currentTime = convertStringToIntegerTime(current);
        int correctTime = convertStringToIntegerTime(correct);
        return getMinimumNumberOfOperation(correctTime - currentTime);
    }

    private int getMinimumNumberOfOperation(int diff) {
        int numberOfOperation = 0;
        int[] operations = {60, 15, 5, 1};

        for (int operation : operations) {
            numberOfOperation += diff / operation;
            diff %= operation;
        }

        return numberOfOperation;
    }

    private int convertStringToIntegerTime(String correct) {
        String[] split = correct.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}
