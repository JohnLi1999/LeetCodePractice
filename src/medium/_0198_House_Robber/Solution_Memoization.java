package medium._0198_House_Robber;

import java.util.Arrays;

/*  https://leetcode.com/problems/house-robber/
    Time complexity: O(n)
        We used cache array to save results, so it is linear time complexity.
    Space complexity: O(n)
        The cache array needs extra space
 */
public class Solution_Memoization {
    private int[] nums;
    private int[] cache;

    public int rob(int[] nums) {
        this.nums = nums;
        this.cache = new int[nums.length];
        Arrays.fill(this.cache, -1);
        return memoization(0);
    }

    public int memoization(int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (cache[i] != -1) {
            return cache[i];
        }

        int selected = nums[i] + memoization(i + 2);
        int notSelected = memoization(i + 1);
        cache[i] = Math.max(selected, notSelected);
        return cache[i];
    }
}
