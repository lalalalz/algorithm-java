package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteppingStoneX {

    private final int MAX = 0xffffff;

    public int solution(int[] stones, int k) {
        int answer = MAX;

        List<Integer> stonesList = Arrays.stream(stones).boxed().collect(Collectors.toList());
        stonesList.add(0, MAX);
        stonesList.add(MAX);
        Integer[] objects = stonesList.toArray(new Integer[0]);

        List<Integer> maximumPeopleToKLengthCross = getMaximumPeopleToKLengthCross(objects, k);

        for (Integer peopleToKLengthCross : maximumPeopleToKLengthCross) {
            answer = Math.min(answer, peopleToKLengthCross);
        }

        return answer = (answer >= MAX ? 0 : answer);
    }

    private List<Integer> getMaximumPeopleToKLengthCross(Integer[] stones, int k) {
        List<Integer> maximumPeopleToKLengthCross = new ArrayList<>();

        for (int i = 0; i + k + 1 < stones.length; i++) {
            if (isIncludedSection(i, i + k + 1, stones)) {
                maximumPeopleToKLengthCross.add(getMaximumPeople(i, i + k + 1, stones));
            }
        }

        return maximumPeopleToKLengthCross;
    }

    private int getMaximumPeople(int start, int end, Integer[] stones) {
        int max = 0;

        for (int i = start + 1; i < end; i++) {
            if (stones[i] > max) {
                max = stones[i];
            }
        }

        return max;
    }

    private boolean isIncludedSection(int start, int end, Integer[] stones) {
        int min = Math.min(stones[start], stones[end]);

        for (int i = start + 1; i < end; i++) {
            if(stones[i] > min) return false;
        }

        return true;
    }
}
