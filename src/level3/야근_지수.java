package level3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class 야근_지수 {

    public static void main(String[] args) {
        야근_지수 야근_지수 = new 야근_지수();
        야근_지수.solution(1, new int[]{2, 1, 2});
    }
    public long solution(int n, int[] works) {
        return getMinimumFatigue(n, works);
    }

    private long getMinimumFatigue(int n, int[] works) {
        long answer = 0L;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            treeMap.put(works[i], treeMap.getOrDefault(works[i], 0) + 1);
        }

        while (n > 0) {
            Map.Entry<Integer, Integer> work = treeMap.pollFirstEntry();
            Integer count = work.getValue();

            if (count > n) {
                treeMap.put(work.getKey(), count - n);
                treeMap.put(work.getKey() - 1, treeMap.getOrDefault(work.getKey() - 1, 0) + n);
            }
            else {
                treeMap.put(work.getKey() - 1, treeMap.getOrDefault(work.getKey() - 1, 0) + count);
            }

            n -= count;
        }

        return calcFatigue(treeMap);
    }

//    private long getMinimumFatigue(int n, int[] works) {
//        long result = Long.MAX_VALUE;
//
//        if (n == 0) {
//            return calcFatigue(works);
//        }
//
//        for (int i = 0; i < works.length; i++) {
//            if (works[i] > 0) {
//                works[i]--;
//                result = Math.min(result, getMinimumFatigue(n - 1, works));
//                works[i]++;
//            }
//        }
//
//        return result;
//    }
//
    private long calcFatigue(TreeMap<Integer, Integer> treeMap) {
        long fatigue = 0L;

        for (Map.Entry<Integer, Integer> work : treeMap.entrySet()) {
            Integer workStrength = work.getKey();
            Integer workCount = work.getValue();

            if (workStrength > 0) {
                fatigue += (long) Math.pow(workStrength, 2) * workCount;
            }
        }

        return fatigue;
    }

//    private long calcFatigue(int[] works) {
//        long fatigue = 0L;
//
//        for (int work : works) {
//            fatigue += (long) work * work;
//        }
//
//        return fatigue;
//    }


}
