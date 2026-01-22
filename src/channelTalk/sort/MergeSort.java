package channelTalk.sort;

import java.util.Arrays;

public class MergeSort {

    private int[] sorted;

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {4, 5, 1, 3, 2};
        mergeSort.mergeSort(0, array.length - 1, array);
        System.out.println("mergeSort = " + Arrays.toString(array));
    }

    void mergeSort(int left, int right, int[] array) {
        if (array == null || array.length == 0 || left >= right) {
            return;
        }
        if (sorted == null || sorted.length != array.length) {
            sorted = new int[array.length];
        }
        int mid = left + (right - left) / 2;

        mergeSort(left, mid, array);
        mergeSort(mid + 1, right, array);
        merge(left, right, array);
    }

    void merge(int left, int right, int[] array) {
        int index = left;
        int mid = (left + right) / 2;
        int firstPoint = left;
        int secondPoint = mid + 1;

        while (firstPoint <= mid && secondPoint <= right) {
            if (array[firstPoint] <= array[secondPoint]) {
                sorted[index++] = array[firstPoint++];
            }
            else {
                sorted[index++] = array[secondPoint++];
            }
        }

        if (firstPoint <= mid) {
            for (int i = firstPoint; i <= mid; i++) {
                sorted[index++] = array[i];
            }
        }
        if (secondPoint <= right) {
            for (int i = secondPoint; i <= right; i++) {
                sorted[index++] = array[i];
            }
        }

        for (int i = left; i <= right; i++) {
            array[i] = sorted[i];
        }
    }
}
