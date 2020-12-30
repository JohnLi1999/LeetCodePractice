package hard._0004_Median_of_Two_Sorted_Arrays.notes;

/*  This solution is from blog
    https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46

    Time complexity: O( log(min(m,n)) )
    Space complexity: O(1)
 */
public class Sample_Solution_with_Clarification {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException();
        }

        int aLen = nums1.length;
        int bLen = nums2.length;

        // Make sure we always search the shorter array.
        if (aLen > bLen) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = aLen; aLen = bLen; bLen = tmp;
        }

        int leftHalfLen = (aLen + bLen + 1) / 2;

        // Since nums1 is guaranteed to be the shorter array,
        // we know it can contribute 0 or all of its values.
        int aMinCount = 0;
        int aMaxCount = aLen;

        while (aMinCount <= aMaxCount)
        {
            int aCount = aMinCount + ((aMaxCount - aMinCount) / 2);
            int bCount = leftHalfLen - aCount;

            //
            // Make sure aCount is greater than 0 (because nums1 can contribute 0 values;
            // remember that nums1 is either shorter or of the same length as nums2). This also
            // implies bCount will be less than nums2.Length since it won't be possible
            // for nums2 to contribute all of its values if nums1 has contributed at least 1
            // value.
            //
            if (aCount > 0 && nums1[aCount - 1] > nums2[bCount])
            {
                // Decrease nums1's contribution size; x lies in the right half.
                aMaxCount = aCount - 1;
            }

            //
            // Make sure aCount is less than nums1.Length since nums1 can actually contribute
            // all of its values (remember that nums1 is either shorter or of the same
            // length as nums2). This also implies bCount > 0 because nums2 has to contribute
            // at least 1 value if aCount < nums1.Length.
            //
            else if (aCount < aLen && nums2[bCount - 1] > nums1[aCount])
            {
                // Decrease nums2's contribution size, i.e. increase nums1's contribution size;
                // y lies in the right half.
                aMinCount = aCount + 1;
            }
            else
            {
                //
                // Neither x nor y lie beyond the left half. We found the right aCount.
                // We don't know how x and y compare to each other yet though.
                //

                //
                // If aLen + bLen is odd, the median is the greater of x and y.
                //
                int leftHalfEnd =
                        (aCount == 0)             // nums1 not contributing?
                                ? nums2[bCount - 1]       // aCount = 0 implies bCount > 0
                                : (bCount == 0)       // nums2 is not contributing?
                                ? nums1[aCount - 1]   // bCount = 0 implies aCount > 0
                                : Math.max(nums1[aCount - 1], nums2[bCount - 1]);

                if (IsOdd(aLen + bLen))
                {
                    return leftHalfEnd;
                }

                //
                // aLen + bLen is even. To compute the median, we need to find
                // the first element in the right half, which will be the smaller
                // of nums1[aCount] and nums2[bCount]. Remember that aCount could be equal
                // to nums1.Length, bCount could be equal to nums2.Length (if all the values
                // of nums1 or nums2 are in the left half).
                //
                int rightHalfStart =
                        (aCount == aLen)          // nums1 is all in the left half?
                                ? nums2[bCount]           // aCount = aLen implies bCount < nums2.Length
                                : (bCount == bLen)    // nums2 is all in the left half?
                                ? nums1[aCount]       // bCount = nums2.Length implies aCount < nums1.Length
                                : Math.min(nums1[aCount], nums2[bCount]);
                return (leftHalfEnd + rightHalfStart) / 2.0;
            }
        }

        return -1;
    }

    // The least significant bit of any odd number is 1.
    private boolean IsOdd(int x) {
        return (x & 1) == 1;
    }
}
