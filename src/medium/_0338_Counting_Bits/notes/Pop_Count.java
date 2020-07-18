package medium._0338_Counting_Bits.notes;

/*  Time complexity: O(nk)
        For each integer x, we need O(k) operations where k is the number of bits in x.
    Space complexity: O(n)
        We need O(n) space to store the count results.
        If we exclude that, it costs only constant space.
 */
public class Pop_Count {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = popcount(i);
        return ans;
    }

    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; // zeroing out the least significant nonzero bit
        return count;
    }
}