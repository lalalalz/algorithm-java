package leetCode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeArrays(nums1, nums2);
        int mid = mergedArray.length / 2;

        if(mergedArray.length % 2 > 0) {
            return mergedArray[mergedArray.length / 2];
        }

        if (mergedArray.length > 0) {
            return (mergedArray[mid] + mergedArray[mid - 1]) / 2.0;
        }

        return 0.0;
    }

    private int[] mergeArrays(int[] first, int[] second) {
        int firstIndex  = 0;
        int secondIndex = 0;
        int mergedArrayIndex = 0;

        int[] merged = new int[first.length + second.length];

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                merged[mergedArrayIndex++] = first[firstIndex++];
            }
            else {
                merged[mergedArrayIndex++] = second[secondIndex++];
            }
        }

        while (firstIndex < first.length) {
            merged[mergedArrayIndex++] = first[firstIndex++];
        }

        while (secondIndex < second.length) {
            merged[mergedArrayIndex++] = second[secondIndex++];
        }

        return merged;
    }
}
