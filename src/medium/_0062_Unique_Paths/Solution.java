package medium._0062_Unique_Paths;

import java.util.Arrays;

/*  https://leetcode.com/problems/unique-paths/
    Time complexity: O(m * n)
        We need to traverse all m * n positions
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        return dp_1d_array(m, n);
//        return dp_2d_array(m, n);
    }

    /*  Space complexity: O(n)
            We use an 1D dp array
     */
    public int dp_1d_array(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[n - 1];
    }


    /*  Space complexity: O(m * n)
            We use a 2D dp array
     */
    public int dp_2d_array(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
