package leetCode;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int removedNumber = countElementOfNoneVal(nums, val);
        arrangement(nums, val);
        return removedNumber;
    }

    private int countElementOfNoneVal(int[] nums, int val) {
        return (int) Arrays.stream(nums)
                .filter(n -> n != val)
                .count();
    }

    private void arrangement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                moveToFront(nums, val, i);
            }
        }
    }

    private void moveToFront(int[] nums, int val, int positionOfNoneVal) {
        int pos = positionOfNoneVal;

        while (pos - 1 >= 0 && nums[pos - 1] == val) {
            swap(nums, pos, pos - 1);
            pos--;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
