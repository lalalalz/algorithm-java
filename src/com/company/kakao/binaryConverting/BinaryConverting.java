package com.company.kakao.binaryConverting;

public class BinaryConverting {

    private int convertCounts = 0;
    private int removedZeroCounts = 0;

    public int[] solution(String number) {

        while (!number.equals("1")) {
            number = removedZero(number);
//            number = convert(number);
        }

        return new int[]{convertCounts, removedZeroCounts};
    }

    private String removedZero(String number) {
        String newNumber = "";

        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '0') removedZeroCounts++;
            else newNumber += "1";
        }

        return newNumber;
    }

    private void convert(String number) {

    }
}
