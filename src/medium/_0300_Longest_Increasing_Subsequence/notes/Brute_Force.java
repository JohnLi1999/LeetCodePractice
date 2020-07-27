package medium._0300_Longest_Increasing_Subsequence.notes;

/*  Time complexity: O(2^n)
        Size of recursion tree will be 2^n.
    Space complexity: O(n^2)
        The size of the stack used for recursions
 */
public class Brute_Force {
    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
}