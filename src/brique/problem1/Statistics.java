package brique.problem1;

import java.util.Arrays;
import java.util.List;

public class Statistics {

    private double[] numbers = new double[10];

    public Statistics(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            numbers[i] = Double.parseDouble(input.get(i));
        }

        Arrays.sort(numbers);
    }

    public double getMin() {
        return Arrays.stream(numbers)
                .min()
                .getAsDouble();
    }

    public double getMax() {
        return Arrays.stream(numbers)
                .max()
                .getAsDouble();
    }

    public double getSum() {
        return Arrays.stream(numbers)
                .sum();
    }

    public double getAverage() {
        return Arrays.stream(numbers)
                .average()
                .getAsDouble();
    }

    public double getStandardDeviation() {
        double devSqvSum = 0.0;
        double average = getAverage();

        for (double number : numbers) {
            double dev = average - number;
            devSqvSum += dev * dev;
        }

        return Math.sqrt(devSqvSum / (numbers.length - 1));
    }

    public double getMedian() {
        int mid = numbers.length / 2;

        if (numbers.length % 2 == 0) {
            return (numbers[mid] + numbers[mid - 1]) / 2;
        }

        return numbers[mid];
    }
}
