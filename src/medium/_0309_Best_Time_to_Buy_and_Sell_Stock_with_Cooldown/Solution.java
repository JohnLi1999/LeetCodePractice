package medium._0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        Time Complexity: O(n^2)
            Where n is the length of the prices sequence
        Space Complexity: O(n^2)
            Where n is the length of the prices sequence
            The size of the DP_Bottom_Up array is n * n/2 * 2 * 2 = 2n^2,
            so the space complexity is O(n^2)
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;

        if (length < 2) {
            return 0;
        }

        int maxTransactions = length / 2;
        int[][][][] profits = new int[length][maxTransactions + 1][2][2];

        for (int t = 0; t <= maxTransactions; t++) {
            profits[0][t][1][0] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= maxTransactions; j++) {
                profits[i][j][0][0] = Math.max(profits[i - 1][j][0][0],
                                               profits[i - 1][j][0][1]);
                profits[i][j][1][0] = Math.max(profits[i - 1][j][1][0],
                                               profits[i - 1][j][0][0] - prices[i]);
                if (j > 0) {
                    profits[i][j][0][1] = profits[i - 1][j - 1][1][0] + prices[i];
                }
            }
        }

        return Math.max(profits[length - 1][maxTransactions][0][0],
                        profits[length - 1][maxTransactions][0][1]);
    }
}
