package level1.programmers;

public class WhatDay {

    private int[] numberOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "THU"};

    public String solution(int a, int b) {
        int dates = makeDates(a, b);
        return makeDays(dates);
    }

    private int makeDates(int month, int day) {
        int result = 0;

        for (int i = 1; i < month; i++) {
            result += numberOfDays[i - 1];
        }

        return result + day - 1;
    }

    private String makeDays(int dates) {
        int rest = dates;

        while (dates >= 7) {
            rest = dates % 7;
            dates /= 7;
        }

        return days[rest];
    }
}
