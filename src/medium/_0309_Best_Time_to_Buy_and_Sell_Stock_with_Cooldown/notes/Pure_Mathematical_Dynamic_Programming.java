package medium._0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.notes;

public class Pure_Mathematical_Dynamic_Programming {
    /*  Time Complexity: O(N^2)
            Where N is the length of the price list.
            As one can see, we have nested loops over the price list.
            The number of iterations in the outer loop is N.
            The number of iterations in the inner loop varies from 1 to N.
            Therefore, the total number of iterations that we perform is ∑(^N _i=1) i = N * (N + 1) / 2
            As a result, the overall time complexity of the algorithm is O(N^2).
        Space Complexity: O(N)
            Where N is the length of the price list.
            We allocated an array to hold all the values for our target function MP(i).
     */
    public int maxProfit(int[] prices) {
        int[] MP = new int[prices.length + 2];

        for (int i = prices.length - 1; i >= 0; i--) {
            int C1 = 0;
            // Case 1). buy and sell the stock
            for (int sell = i + 1; sell < prices.length; sell++) {
                int profit = (prices[sell] - prices[i]) + MP[sell + 2];
                C1 = Math.max(profit, C1);
            }

            // Case 2). do no transaction with the stock p[i]
            int C2 = MP[i + 1];

            // wrap up the two cases
            MP[i] = Math.max(C1, C2);
        }
        return MP[0];
    }
}