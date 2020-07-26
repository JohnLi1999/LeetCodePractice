package hard._0188_Best_Time_to_Buy_and_Sell_Stock_IV.notes;

public class Dynamic_Programming {
    /*  Time Complexity: O(nk) if 2k ≤ n
                         O(n) if 2k > n
            Where n is the length of the prices sequence, since we have two for-loop.
        Space Complexity: O(nk) without state-compressed
                          O(k) with state-compressed
            Where n is the length of the prices sequence.
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // solve special cases
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (2 * k > n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        // dp[i][used_k][ishold] = balance
        // ishold: 0 nothold, 1 hold
        int[][][] dp = new int[n][k + 1][2];

        // initialize the array with -inf
        // we use -1e9 here to prevent overflow
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1000000000;
                dp[i][j][1] = -1000000000;
            }
        }

        // set starting value
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        // fill the array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                // transition equation
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // you can't hold stock without any transaction
                if (j > 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= k; j++) {
            res = Math.max(res, dp[n - 1][j][0]);
        }

        return res;

//        /*  My Way  */
//        int[][][] profits = new int[length][k+1][2];
//        for (int j = 0; j < k; j++) {
//            profits[0][j][1] = -prices[0];
//        }
//
//        for (int i = 1; i < length; i++) {
//            for (int j = 0; j <= k; j++) {
//                if (j > 0) {
//                    profits[i][j][0] = Math.max(profits[i - 1][j][0], profits[i - 1][j - 1][1] + prices[i]);
//                }
//                profits[i][j][1] = Math.max(profits[i - 1][j][1], profits[i - 1][j][0] - prices[i]);
//            }
//        }
//
//        return profits[length - 1][k][0];
    }
}