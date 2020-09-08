package medium._0307_Range_Sum_Query_Mutable.notes;

/*  Time complexity:
            O(n) - preprocessing,
            O(sqrt(n)) - range sum query,
            O(1) - update query
        For range sum query in the worst-case scenario we have to sum approximately 3 * sqrt(n) elements.
        In this case the range includes sqrt(n) - 2 blocks, which total sum costs sqrt(n) - 2 operations.
        In addition to this we have to add the sum of the two boundary blocks.
        This takes another 2 * ((sqrt(n) - 1) operations.
        The total amount of operations is around 3 sqrt(n)
    Space complexity : O(sqrt(n))
        We need additional sqrt(n) memory to store all block sums.
 */
public class NumArray_Sqrt_Decomposition {
    private int[] b;
    private int len;
    private int[] nums;

    public NumArray_Sqrt_Decomposition(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length/l);
        b = new int [len];
        for (int i = 0; i < nums.length; i++)
            b[i / len] += nums[i];
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += b[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void update(int i, int val) {
        int b_l = i / len;
        b[b_l] = b[b_l] - nums[i] + val;
        nums[i] = val;
    }
}
