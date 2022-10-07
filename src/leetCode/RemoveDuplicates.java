package leetCode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        return getRemovedDuplicates(nums);
    }

    private int getRemovedDuplicates(int[] nums) {
        int index = 1;
        int current = 1;

        while (current < nums.length) {
            if (nums[current - 1] != nums[current]) {
                nums[index] = nums[current];
                index++;
            }
            current++;
        }

        return index;
    }
}
