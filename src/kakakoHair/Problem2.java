package kakakoHair;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public long solution(long n) {
        return getNthNumber(n);
    }

    private long getNthNumber(long n) {
        int multiplicativeSquare = 1;
        HashSet<Integer> numbers = new HashSet<>();

        while (true) {
            numbers.add(multiplicativeSquare);
            numbers.addAll(getCombinationNumbers(multiplicativeSquare));

            if (numbers.size() >= n) {
                break;
            }

            multiplicativeSquare *= 3;
        }

        return getAnswer(numbers, n);
    }

    private long getAnswer(HashSet<Integer> numbers, long n) {
        List<Integer> collect = numbers.stream().sorted().collect(Collectors.toList());
        return collect.get((int) n);

    }

    private Set<Integer> getCombinationNumbers(int multiplicativeSquare) {
        Set<Integer> combinationNumbers = new HashSet<>();

        for (int i = 1; i <= multiplicativeSquare; i*=3) {
            for (int j = 1; j <= multiplicativeSquare; j*=3) {
                combinationNumbers.add(i + j);
            }
        }
        return combinationNumbers;
    }
}
