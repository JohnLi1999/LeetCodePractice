package hard._0004_Median_of_Two_Sorted_Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Brute_Force solutionBruteForce = new Solution_Brute_Force();

    @Test
    void test1() {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        assertEquals(2, solutionBruteForce.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test2() {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        assertEquals(2.5, solutionBruteForce.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test3() {
        int[] nums1 = { 0, 0 };
        int[] nums2 = { 0, 0  };
        assertEquals(0, solutionBruteForce.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test4() {
        int[] nums1 = { };
        int[] nums2 = { 1 };
        assertEquals(1, solutionBruteForce.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void test5() {
        int[] nums1 = { 2 };
        int[] nums2 = {  };
        assertEquals(2, solutionBruteForce.findMedianSortedArrays(nums1, nums2));
    }

}