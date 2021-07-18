package medium._0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {1,2,3,0,2})); // 3
        System.out.println(s.maxProfit(new int[] {1})); // 0
    }

    /*  Time complexity: O(n)
        Space complexity: O(1)

        This is my way: still keep buy and profit, but we have to
        apply the cooldown rules into the recurrences.

        buy[i] = min(buy[i-1], price[i] - profit[i-2])
        profit[i] = max(profit[i-1], price[i] - buy[i])

        The only difference is in the recurrence of buying price.
        When calculating the cumulative buying price,
        any profit made on the previous day cannot be added in since
        the previous day is the cooldown day and we cannot make any profit.
        That is the reason for price[i] - profit[i-2].
     */
    public int maxProfit(int[] prices) {
        /*  buy[i] = min(buy[i-1], price[i] - profit[i-2])
            profit[i] = max(profit[i-1], price[i] - buy[i])
         */

        int buy = Integer.MAX_VALUE;
        int profit = 0;
        int preProfit = 0;
        int prePreProfit;

        for (int price : prices) {
            prePreProfit = preProfit;
            preProfit = profit;

            buy = Math.min(buy, price - prePreProfit);
            profit = Math.max(profit, price - buy);
        }

        return profit;
    }

//    /*  Time complexity: O(n)
//        Space complexity: O(1)
//
//        State machine solution:
//              ---
//             |   v         sell
//        rest |   [held] ---------> [sold]
//              ---    ^                | rest
//                 buy |                |
//                     ---- [reset] <----
//                          ^     |
//                          |     |
//                          -------
//                            rest
//        - We are either in held, sold, or reset state, and
//          rest state is for cooldown rule.
//        - Recurrences:
//            sold[i] = price[i] - held[i - 1]
//            held[i] = min(held[i - 1], price[i] - reset[i - 1])
//            reset[i] = max(reset[i - 1], sold[i - 1])
//        - Be careful with the held and reset, both of them presents profits.
//          So we need to return the larger of them at the end
//     */
//    public int maxProfit(int[] prices) {
//        int held = Integer.MAX_VALUE;
//        int sold = 0;
//        int reset = 0;
//
//        for (int price : prices) {
//            int preSold = sold;
//
//            sold = price - held;
//            held = Math.min(held, price - reset);
//            reset = Math.max(reset, preSold);
//        }
//
//        return Math.max(sold, reset);
//    }

//    /*  Time complexity: O(n)
//        Space complexity: O(n)
//     */
//    public int maxProfit(int[] prices) {
//        /*  buy[i] = min(buy[i-1], price[i] - profit[i-1])
//            profit[i] = max(profit[i-1], price[i] - buy[i])
//
//            buy[i] = min(buy[i-1], price[i] - profit[i-2])
//            profit[i] = max(profit[i-1], price[i] - buy[i-2]);
//         */
//
//        int[] buys = new int[prices.length];
//        int[] profits = new int[prices.length];
//
//        for (int i = 0; i < prices.length; i++) {
//            if (i == 0) {
//                buys[0] = Math.min(Integer.MAX_VALUE, prices[0]);
//                profits[0] = Math.max(0, prices[0] - Integer.MAX_VALUE);
//            } else if (i == 1) {
//                buys[1] = Math.min(buys[0], prices[1]);
//                profits[1] = Math.max(profits[0], prices[i] - buys[0]);
//            } else {
//                buys[i] = Math.min(buys[i - 1], prices[i] - profits[i - 2]);
//                profits[i] = Math.max(profits[i - 1], prices[i] - buys[i - 1]);
//            }
//        }
//
//        return profits[prices.length - 1];
//    }
}
