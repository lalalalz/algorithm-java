package brique.problem1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        CSVConverter converter = new CSVConverter();
        List<List<String>> convertedData = converter.readCSV("src/brique/problem1/resource/sample.csv");

        List<String> nonNumbers = new ArrayList<>();
        List<Statistics> statistics = new ArrayList<>();

        parseData(convertedData, statistics, nonNumbers);
        printStatistics(convertedData, statistics, nonNumbers);
    }

    private static void parseData(List<List<String>> convertedData, List<Statistics> statistics, List<String> nonNumbers) {
        for (List<String> row : convertedData) {
            if (isAllDigits(row)) {
                statistics.add(new Statistics(row));
            }
            else {
                nonNumbers.addAll(getNonNumbers(row));
            }
        }
    }

    private static List<String> getNonNumbers(List<String> row) {
        List<String> nonNumbers = new ArrayList<>();

        for (String data : row) {
            if (!isDigit(data)) {
                nonNumbers.add(data);
            }
        }

        return nonNumbers;
    }

    private static boolean isAllDigits(List<String> row) {
        for (String number : row) {
            if (!isDigit(number)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static void printStatistics(List<List<String>> source, List<Statistics> statistics, List<String> nonNumbers) {
        System.out.println("Solution.printStatistics");
        for (Statistics statistic : statistics) {
            System.out.println(statistic.getMin() + " " + statistic.getMax() + " " +
                    statistic.getSum() + " " + statistic.getAverage() + " " +
                    statistic.getStandardDeviation() + " " + statistic.getMedian());
        }

        System.out.println("---------------------------------------------");
        System.out.println("The total number of lines: " + statistics.size());
        System.out.println("The calculated lines: " + source.size());

        printNonNumbers(nonNumbers);
    }

    private static void printNonNumbers(List<String> nonNumbers) {
        System.out.print("The error values: ");

        for (String nonNumber : nonNumbers) {
            System.out.print(nonNumber + " ");
        }
    }
}
