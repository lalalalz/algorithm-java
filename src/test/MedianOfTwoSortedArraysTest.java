package test;

import leetCode.MedianOfTwoSortedArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

    @Test
    void test1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 7};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(2.5, result);
    }

}