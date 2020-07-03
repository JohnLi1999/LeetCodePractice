package easy._0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        Time complexity: O(n)
            Only a single pass is needed.
        Space complexity: O(1)
            Only two variables are used.
     */
    public static int maxProfit_OnePass(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else if ((prices[i] - min_price) > max_profit) {
                max_profit = prices[i] - min_price;
            }
        }

        return max_profit;
    }

    /*  Time complexity: O(n^2)
            Loop runs n(n-1)/2 times.
        Space complexity: O(1)
            Only two variables max_profit and profit are used.
     */
    public static int maxProfit_BruteForce(int[] prices) {
        int max_profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max_profit) {
                    max_profit = profit;
                }
            }
        }

        return max_profit;
    }
}
