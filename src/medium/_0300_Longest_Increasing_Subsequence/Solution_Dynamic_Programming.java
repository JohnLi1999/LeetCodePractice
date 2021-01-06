package medium._0300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution_Dynamic_Programming {
    /*  https://leetcode.com/problems/longest-increasing-subsequence/
        Time Complexity: O(n^2)
            We used two nested loops
        Space Complexity: O(1)
            DP_Bottom_Up array of size n is used
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
