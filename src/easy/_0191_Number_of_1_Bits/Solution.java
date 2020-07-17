package easy._0191_Number_of_1_Bits;

public class Solution {
    /*  https://leetcode.com/problems/number-of-1-bits/
        Time Complexity: O(1)
            The run time depends on the number of 1-bits in n.
            In the worst case, all bits in n are 1-bits.
            In case of a 32-bit integer, the run time is O(1).
        Space Complexity: O(1)
            Since no additional space is allocated.
     */

    public static int hammingWeight_unsigned_right_shift(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }

            // Unsigned right shift
            n = (n >>> 1);
        }

        return count;
    }

    public static int hammingWeight_Bit_Manipulation_Trick(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n &= (n - 1);
        }

        return count;
    }
}
