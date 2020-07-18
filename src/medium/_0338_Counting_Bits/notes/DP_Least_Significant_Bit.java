package medium._0338_Counting_Bits.notes;

/*  Time complexity: O(n)
        For each integer x we need constant operations which do not depend on the number of bits in x.
    Space complexity: O(n)
        We need O(n) space to store the count results.
        If we exclude that, it costs only constant space.
 */
public class DP_Least_Significant_Bit {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
