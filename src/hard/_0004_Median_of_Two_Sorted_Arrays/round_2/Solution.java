package hard._0004_Median_of_Two_Sorted_Arrays.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays_BinarySearch(new int[] {1,3}, new int[] {2})); // 2.0
        System.out.println(s.findMedianSortedArrays_BinarySearch(new int[] {1,2}, new int[] {3,4})); // 2.5
        System.out.println(s.findMedianSortedArrays_BinarySearch(new int[] {0,0}, new int[] {0,0})); // 0.0
        System.out.println(s.findMedianSortedArrays_BinarySearch(new int[] {}, new int[] {1})); // 1.0
        System.out.println(s.findMedianSortedArrays_BinarySearch(new int[] {2}, new int[] {})); // 2.0

        System.out.println();

        System.out.println(s.findMedianSortedArrays_BruteForce(new int[] {1,3}, new int[] {2})); // 2.0
        System.out.println(s.findMedianSortedArrays_BruteForce(new int[] {1,2}, new int[] {3,4})); // 2.5
        System.out.println(s.findMedianSortedArrays_BruteForce(new int[] {0,0}, new int[] {0,0})); // 0.0
        System.out.println(s.findMedianSortedArrays_BruteForce(new int[] {}, new int[] {1})); // 1.0
        System.out.println(s.findMedianSortedArrays_BruteForce(new int[] {2}, new int[] {})); // 2.0
    }

    /*  Time complexity: O(log( min(m,n) ))
        Space complexity: O(1)
     */
    public double findMedianSortedArrays_BinarySearch(int[] nums1, int[] nums2) {
        /*  Even:
            x: 1 4 6 | 10
            y: 3 | 7 15 20
            -> 1 3 4 [6 7] 10 15 20
            -> length: (4 + 4 + 1) / 2 = 4

            x: 3 8 | 9 10
            y: 2 4 6 | 12 18 20
            -> 2 3 4 6 [8 9] 10 12 18 20
            -> length: (4 + 6 + 1) / 2 = 5

            Odd:
            1 4 6 | 10
            3 7 | 15 20 30
            -> 1 3 4 6 [7] 10 15 20 30
            -> length: (4 + 5 + 1) / 2 = 5

            x: 3 8 | 9 12
            y: 2 4 6 7 | 11 18 20
            -> 2 3 4 6 7 [8] 9 11 12 18 30
            -> length: (4 + 7 + 1) / 2 = 6

            Only one is involved
            x: | 8
            y: 2 3 4 5 | 6 7
            -> 2 3 4 [5] 6 7 8

            x: 1 2 3 | 4 5
            y: | 6
            -> 1 2 [3 4] 5 6

            Summary:
                1. Number of elements to included for calculating median: (m + n + 1) / 2
                2. Make sure array x is always the shorter array
                3. Set a variable i,
                   it will be count of elements in array x contributed to median.
                   So i is in [0, x.length].
                    -> 0 is for the case none of elements is included
                    -> x.length is for the case all of elements in array x are included
                4. if x contains i elements included
                    -> y should include: j = ((m + n + 1) / 2 - i) elements
                    -> we should compare these four elements
                        x[i-1] | x[i]
                        y[j-1] | y[j]
                5. When x[i-1] <= y[j] && y[j-1] <= x[i], the median is ready:
                    if (m + n) is even:
                        median = (max(x[i-1], y[j-1]) + min(x[i], y[j])) / 2.0
                    if (m + n) is odd:
                        media = max(x[i-1], y[j-1])
                6. If x[i-1] > y[j]
                    search x left half
                   If x[i] < y[i-1]
                    search x right half
         */

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays_BinarySearch(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        /*  For the binary search part, we only to care about the count of elements in nums1.
            This is because the count of elements in nums2
            can be calculated by the count of elements in nums1
         */
        int xLow = 0;
        int xHigh = m;

        while (xLow <= xHigh) {
            int countX = xLow + (xHigh - xLow) / 2;
            int countY = (m + n + 1) / 2 - countX;

            int xLeft = countX == 0 ? Integer.MIN_VALUE : nums1[countX - 1];
            int xRight = countX == m ? Integer.MAX_VALUE : nums1[countX];
            int yLeft = countY == 0 ? Integer.MIN_VALUE : nums2[countY - 1];
            int yRight = countY == n ? Integer.MAX_VALUE : nums2[countY];

            if (xLeft <= yRight && yLeft <= xRight) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2.0;
                } else {
                    return Math.max(xLeft, yLeft);
                }
            } else if (xLeft > yRight) {
                xHigh = countX - 1;
            } else {
                xLow = countX + 1;
            }
        }

        return 0.0;
    }

    /*  Space complexity: O(m + n)
        Space complexity: O(m + n)
     */
    public double findMedianSortedArrays_BruteForce(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] merged = new int[length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        if (i >= nums1.length) {
            while (j < nums2.length) {
                merged[k++] = nums2[j++];
            }
        } else {
            while (i < nums1.length) {
                merged[k++] = nums1[i++];
            }
        }

        if (length % 2  == 0) {
            return (merged[length / 2 - 1] + merged[length / 2]) / (2.0);
        } else {
            return merged[length / 2];
        }
    }
}
