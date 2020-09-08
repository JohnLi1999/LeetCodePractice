package medium._0307_Range_Sum_Query_Mutable.notes;

/*  Time complexity:
            O(n) - range sum query
            O(1) - update query
        For range sum query we access each element from the array for constant time and
        in the worst case we access n elements. Therefore time complexity is O(n).
        Time complexity of update query is O(1).
    Space complexity: O(1)
 */
public class NumArray_Naive {
    private int[] nums;

    public NumArray_Naive(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int l = i; l <= j; l++) {
            sum += nums[l];
        }
        return sum;
    }
}