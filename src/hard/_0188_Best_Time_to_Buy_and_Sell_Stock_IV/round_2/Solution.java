package hard._0188_Best_Time_to_Buy_and_Sell_Stock_IV.round_2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(2, new int[] {2,4,1})); // 2
        System.out.println(s.maxProfit(2, new int[] {3,2,6,5,0,3})); // 7
        System.out.println(s.maxProfit(0, new int[] {2,4,1})); // 0
    }

    /*  Time complexity: O (max(n * k))
            n -> length of prices array
            k -> number of transactions
        Space complexity: O(k)
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }

        /*  Optional: improving performance for large k
                If the number of allowed transactions is
                at least half of the length of the price array,
                we are guaranteed to make all the available profits.
                So, in this case we can just use the infinite transactions
                solution to simplify the work.
         */
        if (2 * k >= prices.length) {
            int buy = Integer.MAX_VALUE;
            int profit = 0;

            for (int price : prices) {
                buy = Math.min(buy, price - profit);
                profit = Math.max(profit, price - buy);
            }

            return profit;
        }

        // General Solution
        int[] buys = new int[k];
        int[] profits = new int[k];

        Arrays.fill(buys, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    buys[i] = Math.min(buys[i], price);
                } else {
                    buys[i] = Math.min(buys[i], price - profits[i - 1]);
                }

                profits[i] = Math.max(profits[i], price - buys[i]);
            }
        }

        return profits[k - 1];
    }
}
