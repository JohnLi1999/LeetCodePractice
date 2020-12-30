package hard._0004_Median_of_Two_Sorted_Arrays;

/*  https://leetcode.com/problems/median-of-two-sorted-arrays/
    Time complexity: O(m + n)
    Space complexity: O(m + n)
 */
public class Solution_Brute_Force {
    /* Use the merge function in merge sort */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        if (i == m) {
            while (j < n) {
                merged[k++] = nums2[j++];
            }
        } else if (j == n) {
            while (i < m) {
                merged[k++] = nums1[i++];
            }
        }

        if ((m + n) % 2 == 0) {
            return (merged[(m + n) / 2] + merged[(m + n) /2 - 1]) / 2.0;
        } else {
            return merged[(m + n) / 2];
        }
    }
}
