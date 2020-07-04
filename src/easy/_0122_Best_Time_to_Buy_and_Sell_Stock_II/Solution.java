package easy._0122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        Time complexity: O(n)
            Single pass.
        Space complexity: O(1)
            Constant space required.
     */
    public static int maxProfit_Peek_Valley_Approach(int[] prices) {
        int profit = 0;
        int buy;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                buy = prices[i];

                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }

                int sell = prices[i];
                profit += (sell - buy);
            }
        }

        return profit;
    }

    /*  Time complexity: O(n)
            Single pass.
        Space complexity: O(1)
            Constant space required.
     */
    public static int maxProfit_Simple_One_Pass(int[] prices) {
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += (prices[i + 1] - prices[i]);
            }
        }

        return profit;
    }
}
