package level3;

import java.util.Arrays;

public class SteppingStone {

    public int solution(int[] stones, int k) {
        return getMaximumPeopleToCrossRiver(stones, k);
    }

    private int getMaximumPeopleToCrossRiver(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(stones)
                .max()
                .getAsInt();

        while (start <= end) {
            int mid = (start + end) / 2;
            int maxContinuousLength =
                    crossRiver(Arrays.copyOf(stones, stones.length + 1), mid);

            if (maxContinuousLength < k) {
                answer = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return answer;
    }

    private int crossRiver(int[] stones, int mid) {
        int jumpLength = 0;
        int maxJumpLength = 0;

        stones[stones.length - 1] = 0xffffff;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid >= 0) {
                maxJumpLength = Math.max(maxJumpLength, jumpLength);
                jumpLength = 0;
            }
            else {
                jumpLength++;
            }
        }

        return maxJumpLength;
    }
}
