package easy._0191_Number_of_1_Bits.notes;

/*  Time Complexity: O(1)
        The run time depends on the number of 1-bits in n.
        In the worst case, all bits in n are 1-bits.
        In case of a 32-bit integer, the run time is O(1).
    Space Complexity: O(1)
        Since no additional space is allocated.
 */
public class Loop_and_Flip {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
