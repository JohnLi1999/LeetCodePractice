package easy._0122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution_Dynamic_Programming {
    /*  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        Time complexity: O(n)
            Single pass.
        Space complexity: O(1)
            Constant space required.
     */
    public static int maxProfit(int[] prices) {
        int held = Integer.MIN_VALUE;
        int sold = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = Math.max(sold, held + price);
            held = Math.max(held, preSold - price);
        }

        return sold;
    }
}
