package medium._0300_Longest_Increasing_Subsequence.notes;

/*  Time complexity: O(n^2)
        Two loops of n are there.
    Space complexity: O(n)
        DP_Bottom_Up array of size n is used.
 */
public class Dynamic_Programming {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxans = 1;

        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }
}