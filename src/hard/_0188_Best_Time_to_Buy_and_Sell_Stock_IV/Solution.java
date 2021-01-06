package hard._0188_Best_Time_to_Buy_and_Sell_Stock_IV;

import java.util.Arrays;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
        Time Complexity: O(nk) if 2k ≤ n
                         O(n) if 2k > n
            Where n is the length of the prices sequence and k is the number of transactions allowed,
            since we have two for-loop.
        Space Complexity: O(k) if 2k ≤ n
                          O(1) if 2k > n
            Where n is the length of the prices sequence and k is the number of transactions allowed.
     */
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;

        // Special case
        if (prices.length < 2 || k == 0) {
            return 0;
        }

        /*  We need two days to complete one transaction (buy and sell).
            So if the number of transactions allowed is larger than half of the total days,
            we can use greedy algorithm to solve the problem.
            It adds all possible profits on all the days
         */
        if (2 * k > length) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                // If current price is smaller than the prices tomorrow, we add the profit
                profit += Math.max(0, prices[i + 1] - prices[i]);
            }
            return profit;
        }

        /*  We initialize two DP_Bottom_Up arrays
            One to track the profits of buying a stock and
            the other to track the profits of selling a stock
         */
        int[] buy = new int[k];
        int[] sell = new int[k];
        // We need to initialize the array for buying with a very small value to avoid adding unreachable profits
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 0; i < buy.length; i++) {
                // DP_Bottom_Up transition equations
                if (i == 0) {
                    buy[0] = Math.max(buy[0], -price);
                } else {
                    buy[i] = Math.max(buy[i], sell[i - 1] - price);
                }

                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        // The maximum profit is at the last position in the sell array
        return sell[sell.length - 1];
    }
}
