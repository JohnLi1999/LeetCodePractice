package medium._0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        Time Complexity: O(N)
            Where N is the number of prices.
        Space Complexity: O(1)
            The space used by held and hold.
     */
    public int maxProfit(int[] prices, int fee) {
        int held = -prices[0];
        int sold = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = Math.max(sold, held + price - fee);
            held = Math.max(held, preSold - price);
        }

        return sold;
    }
}
