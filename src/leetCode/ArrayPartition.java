package leetCode;

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return getSumOfMinimumValues(nums);
    }

    // 배열을 2개씩 묶어 n개의 쌍을 만들고, 각 쌍에서 작은 값들만을 더했을 때, 모든 경우 중 최대값은?
    // 두 쌍 중 작은 값을 선택하고 이를 모두 더해서 최대값을 만들기 위해서는
    // 두 쌍 중 작은 값을 선택할 때, 최대한 이득이 되는 선택을 진행해야 한다.
    // 그러기 위해서는 두 쌍을 선택할 때 최대한 덜 손해보도록 해야한다.
    // 좀 더 구체적으로 말하면, 두 쌍이 최대한 인접한 값들로 구성되어야 한다.
    // 그래야만, 비슷한 크기의 값 중 작은 값을 골라야 그나마 덜 손해를 보기 때문이다.
    private int getSumOfMinimumValues(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i+=2) {
            result = nums[i];
        }

        return result;
    }
}
