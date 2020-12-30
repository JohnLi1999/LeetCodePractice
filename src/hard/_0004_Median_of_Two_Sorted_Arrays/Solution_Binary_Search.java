package hard._0004_Median_of_Two_Sorted_Arrays;

/*  https://leetcode.com/problems/median-of-two-sorted-arrays/
    Time complexity: O( log(min(m,n)) )
    Space complexity: O(1)
 */
public class Solution_Binary_Search {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // We need to make sure the first array has the shorter length
        return nums1.length < nums2.length ? binarySearch(nums1, nums2) : binarySearch(nums2, nums1);
    }

    private double binarySearch(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;

        /*  Here is the length to include median and all its previous numbers in the final result
            e.g. [s1, s2, s3, s4, s5, s6, s7] - lenIncludedMedian : 4
            e.g. [s1, s2, s3, s4, s5, s6, s7, s8] - lenIncludedMedian :  4
            e.g. [s1, s2, s3, s4, s5, s6, s7, s8, s9] - lenIncludedMedian :  5
         */
        int lenIncludedMedian = (aLen + bLen + 1) / 2;

        /*  Next we need to calculate the boundary values for array a
                The lower boundary is 0
                    This is obvious
                The upper boundary is m (array a's length)
                    This is because we make sure array a's length is shorter than array b's length.
                    So, the extreme case is all values in array might contribute to the values before
                    the median
         */
        int aLow = 0;
        int aHigh = aLen;

        /* Start binary search in array a */
        while (aLow <= aHigh) {
            /*  1.  aCount represent the the number of values contribute to the median from array a
                2.  bCount represent the the number of values contribute to the median from array b
                3.  Notice here we use the count of values contributed, so they are not indices  */
            int aCount = aLow + (aHigh - aLow) / 2;
            int bCount = lenIncludedMedian - aCount;

            /*  Four key values
                a[aCount - 1] --- a
                a[aCount]     --- a'
                b[bCount - 1] --- b
                b[bCount]     --- b'
             */

            if (aCount > 0 && a[aCount - 1] > b[bCount]) {
                /*  Case 1: a > b' => scope in a is too large,
                            we need to include fewer values from array a
                    Here we also check the boundary case: aCount should be at least 1  */
                aHigh = aCount - 1;
            } else if (aCount < aLen && b[bCount - 1] > a[aCount]) {
                /*  Case 2: b > a' => scope in a is too small.
                            we need to include more values from array a
                    Here we also check the boundary case: to make a[aCount] a valida value
                    aCount should less than the length of array a  */
                aLow = aCount + 1;
            } else {
                // If we get here, it means we have found the valid scope in array a and b
                int leftMax, rightMin;

                if (aCount == 0) {
                    /*  If aCount is zero, it means array a does not contribute any value to median.
                        So the corresponding value in array b is leftMax  */
                    leftMax = b[bCount - 1];
                } else if (bCount == 0) {
                    /*  If bCount is zero, it means array b does not contribute any value to median.
                        So the corresponding value in array a is leftMax  */
                    leftMax = a[aCount - 1];
                } else {
                    /*  If both arrays contribute to the median,
                        then the larger value between a and b is leftMax  */
                    leftMax = Math.max(a[aCount - 1], b[bCount - 1]);
                }

                /* If the total count is an odd number, leftMax is the median */
                if ((aLen + bLen) % 2 == 1) {
                    return leftMax;
                }

                /*  If the total count is an event number, we also need to find the rightMin.
                    That is the number of immediately after leftMax */

                if (aCount == aLen) {
                    /*  If array a has contributed all its values,
                        then rightMin is the corresponding value in array b */
                    rightMin = b[bCount];
                } else if (bCount == bLen) {
                    /*  If array b has contributed all its values,
                        then rightMin is the corresponding value in array a */
                    rightMin = a[aCount];
                } else {
                    /*  If none of the array has contributed all its values,
                        then rightMin is the smaller between between a' and b' */
                    rightMin = Math.min(a[aCount], b[bCount]);
                }

                /* The median is the average of leftMax and rightMin */
                return (leftMax + rightMin) / 2.0;
            }
        }

        // If not found, return -1;
        return -1;
    }
}
