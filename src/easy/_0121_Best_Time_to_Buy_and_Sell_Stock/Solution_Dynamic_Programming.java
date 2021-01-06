package easy._0121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution_Dynamic_Programming {
    /*  Time complexity: O(n)
        Only a single pass is needed.
    Space complexity: O(1)
        The space used by held and hold.
 */
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int held = -prices[0];
        int sold = 0;

        for (int price : prices) {
            sold = Math.max(sold, held + price);
            held = Math.max(held, -price);
        }

        return sold;
    }

    /*  Time complexity: O(n)
            Only a single pass is needed.
        Space complexity: O(n)
            The size of 2-D array we use to store profits is n * 3.
            So the space complexity is O(3 * n) = O(n).
     */
    public static int maxProfit_With_Extra_Space(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int result = 0;

        // DP_Bottom_Up Array
        int[][] profit = new int[prices.length][3];
        /*  profit[i][0] represents the overall profit that we neither buy or sell a stock on day i
            profit[i][1] represents the overall profit that we sell a stock on day i
            profit[i][2] represents the overall profit that we buy a stock on day i  */
        profit[0][0] = 0;
        profit[0][1] = -prices[0]; // Assume we buy the stock on day 1, so the profit is negative
        profit[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            // No action
            profit[i][0] = profit[i - 1][0];
            /*  Buy a stock
                We use a max() function because we can only complete one transaction.
                So we need to find out the stock which takes the least cost  */
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            /*  Sell a stock
                Use profit[i - 1][1] is because we always need to buy a stock before selling one  */
            profit[i][2] = profit[i - 1][1] + prices[i];

            // Update maximum profit
            result = Math.max(result, Math.max(profit[i][0], Math.max(profit[i][1], profit[i][2])));
        }

        return result;
    }
}
