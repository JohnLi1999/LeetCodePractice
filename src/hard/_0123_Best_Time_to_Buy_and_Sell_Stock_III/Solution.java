package hard._0123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
        Time Complexity: O(N)
            We only iterate the prices array once
        Space Complexity: O(N)
            We need to an N*3*2 array to store temporal results
     */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        /*  DP_Bottom_Up State:
                profit[i][j][k]
                i (0 -> I): the number of days
                j (0 -> 2): the maximum number (2 in this question) of transactions can be completed
                k (0 or 1): 0 represents no stock is hold
                            1 represents now hold one stock
            DP_Bottom_Up Equations:
                profit[i][0][0] = profit[i - 1][0][0];
                profit[i][0][1] = Max(profit[i - 1][0][1],              // No Action
                                      profit[i - 1][0][0] - prices[i])  // Buy stock at day i
                profit[i][1][0] = Max(profit[i - 1][1][0],              // No Action
                                      profit[i - 1][0][1] + prices[i]); // Sell stock at day i (First Transaction)
                profit[i][1][1] = Max(profit[i - 1][1][1],              // No Action
                                      profit[i - 1][1][0] - prices[i]); // Buy stock at day i
                profit[i][2][0] = Max(profit[i - 1][2][0],              // No action
                                      profit[i - 1][1][1] + prices[i]); // Sell stock at day i (Second Transaction)
         */
        int[][][] profit = new int[prices.length][3][2];
        /*  Initialize the profits as 0 if there is no stock hold
            Initialize the profits as -prices[0] if there is a stock hold
            Reason we do this is to prevent some unreachable profit to add to profit[i][2][0]  */
        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = 0;
        profit[0][1][1] = -prices[0];
        profit[0][2][0] = 0;

        for (int i = 1; i < prices.length; i++) {
            profit[i][0][0] = profit[i - 1][0][0];
            profit[i][0][1] = Math.max(profit[i - 1][0][1], profit[i - 1][0][0] - prices[i]);

            profit[i][1][0] = Math.max(profit[i - 1][1][0], profit[i - 1][0][1] + prices[i]);
            profit[i][1][1] = Math.max(profit[i - 1][1][1], profit[i - 1][1][0] - prices[i]);

            profit[i][2][0] = Math.max(profit[i - 1][2][0], profit[i - 1][1][1] + prices[i]);
         }

        // Return the profit on last day with two transactions
        return profit[prices.length-1][2][0];
    }
}
