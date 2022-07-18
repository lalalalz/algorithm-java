package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class pocketmon {

    public int solution(int[] nums) {
        int answer = 0;

        int pocketMons = nums.length;
        Set<Integer> pocketMonTypes = new HashSet<>();

        for (int num : nums) {
            pocketMonTypes.add(num);
        }

        if (pocketMonTypes.size() < pocketMons / 2) {
            answer = pocketMonTypes.size();
        }
        else {
            answer = pocketMons / 2;
        }

        return answer;
    }

}
