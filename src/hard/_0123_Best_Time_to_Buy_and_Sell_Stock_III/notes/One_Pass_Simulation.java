package hard._0123_Best_Time_to_Buy_and_Sell_Stock_III.notes;

/*  Time Complexity: O(N)
        Where N is the length of the input sequence.
    Space Complexity: O(1)
        Only constant memory is required, which is invariant from the input sequence.
 */
public class One_Pass_Simulation {
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
                t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
                t2Profit = 0;

        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // reinvest the gained profit in the second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }

    /*  My favorite solution  */
    public int maxProfit_way2(int[] prices) {
        int t1Buy = Integer.MIN_VALUE, t2Buy = Integer.MIN_VALUE;
        int t1Sell = 0, t2Sell = 0;

        for (int price : prices) {
            t1Buy = Math.max(t1Buy, -price);            // Buy stock in transaction #1
            t1Sell = Math.max(t1Sell, t1Buy + price);   // Sell stock in transaction #1
            t2Buy = Math.max(t2Buy, t1Sell - price);    // Buy stock in transaction #2
            t2Sell = Math.max(t2Sell, t2Buy + price);   // Sell stock in transaction #2
        }

        return t2Sell;
    }
}
