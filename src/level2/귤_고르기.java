package level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tangerineCountInfo = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            if (tangerineCountInfo.containsKey(tangerine[i])) {
                tangerineCountInfo.put(tangerine[i], tangerineCountInfo.get(tangerine[i]) + 1);
            }
            else {
                tangerineCountInfo.put(tangerine[i], 1);
            }
        }

        return getMinimumTypeCount(tangerineCountInfo
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()), k);
    }

    private int getMinimumTypeCount(List<Integer> sortedTangerineInfo, int k) {
        int sum = 0;
        int count = 0;

        for (Integer tangerineCount : sortedTangerineInfo) {
            if (sum < k) {
                sum += tangerineCount;
                count++;
            }
        }

        return count;
    }
}
