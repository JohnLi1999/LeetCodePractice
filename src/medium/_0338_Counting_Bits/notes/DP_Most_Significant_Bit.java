package medium._0338_Counting_Bits.notes;

/*  Time complexity: O(n)
        For each integer x we need constant operations which do not depend on the number of bits in x.
    Space complexity: O(n)
        We need O(n) space to store the count results.
        If we exclude that, it costs only constant space.
 */
public class DP_Most_Significant_Bit {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int i = 0, b = 1;

        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while (i < b && i + b <= num) {
                result[i + b] = result[i] + 1;
                i++;
            }

            i = 0;   // reset i
            b <<= 1; // b = 2b
        }

        return result;
    }
}
