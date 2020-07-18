package medium._0338_Counting_Bits;

public class Solution {
    /*  https://leetcode.com/problems/counting-bits/
        Time complexity: O(n)
            For each integer x we need constant operations which do not depend on the number of bits in x.
        Space complexity: O(n)
            We need O(n) space to store the count results.
            If we exclude that, it costs only constant space.
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int back = 0;

        for (int i = 1; i <= num; i++) {
            /*  If the number is the power of 2,
                it only contains one 1-bit.
                And in the next "number" of positions,
                we generate the result based on previously results + 1;
            */
            if ((i & (i - 1)) == 0) {
                back = i;
                result[i] = 1;
            } else {
                // Add the results base on the previous results
                result[i] = result[i - back] + 1;
            }
        }

        return result;
    }
}
