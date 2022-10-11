package leetCode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return getFindIndexOf(nums, target);
    }

    private int getFindIndexOf(int[] nums, int target) {
        int mid = 0;
        int end = nums.length - 1;
        int begin = 0;

        while (begin <= end) {
            mid = (begin + end) / 2;

            if (nums[mid] - target > 0) {
                end = mid - 1;
            }

            if (nums[mid] - target < 0) {
                begin = mid + 1;
            }

            if (nums[mid] - target == 0) {
                break;
            }
        }

        return nums[mid] - target >= 0 ? mid : mid + 1;
    }
}
