package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Level1Test {

//    private final int[] dateOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//    private final String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
//
//    public String solution(int month, int date) {
//
//        int totalDate = getTotalDate(month, date);
//        return getDay(totalDate);
//    }
//
//    private int getTotalDate(int month, int date) {
//        int totalDates = date;
//
//        for (int i = 1; i < month - 1; i++) {
//            totalDates += dateOfMonth[i];
//        }
//
//        return totalDates;
//    }
//
//    private String getDay(int totalDate) {
//        return days[(totalDate - 1) % 7];
//    }

    private final int[] firstPattern = {1, 2, 3, 4, 5};
    private final int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] thirdPattern = {3, 3 , 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] countOfAnswer = new int[3];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstPattern[i % firstPattern.length]) {
                countOfAnswer[0]++;
            }

            if (answers[i] == secondPattern[i % secondPattern.length]) {
                countOfAnswer[1]++;
            }

            if (answers[i] == thirdPattern[i % thirdPattern.length]) {
                countOfAnswer[2]++;
            }
        }

        int max = Arrays.stream(countOfAnswer)
                .max()
                .orElse(-1);

        for (int i = 0; i < 3; i++) {
            if (countOfAnswer[i] == max) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
