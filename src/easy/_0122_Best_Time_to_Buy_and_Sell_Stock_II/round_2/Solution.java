package easy._0122_Best_Time_to_Buy_and_Sell_Stock_II.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit(new int[] {1,2,3,4,5})); // 4
        System.out.println(s.maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(s.maxProfit(new int[] {1})); // 0
    }

    /*  Dynamic Programming - think 'buy' as positive values at the beginning
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;

        /*  buy[i] = min(buy[i - 1], price[i] - profit[i - 1])
            profit[i] = max(profit[i - 1], prices[i] - buy[i])

            Explanation:
            1: buy is the lowest prices so far,
                    but in this question, the buying price is a bit tricky,
                    after we made some profit on some day, all the prices after that day
                    will be the original price - the profit made so far
            2: maximum profit is either
                    the maximum profit achieved before or
                    the current price - the current minimum buying price
         */

        for (int price : prices) {
            buy = Math.min(buy, price - profit);
            profit = Math.max(profit, price - buy);
        }

        return profit;
    }

//    /*  Dynamic Programming - think 'buy' as negative values at the beginning
//        Time complexity: O(n)
//        Space complexity: O(1)
//     */
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        int buy = Integer.MIN_VALUE;
//
//        /*  buy[i] = max(buy[i - 1], profit[i - 1] - price[i])
//            profit[i] = max(profit[i - 1], buy[i] + prices[i])
//         */
//
//        for (int price : prices) {
//            buy = Math.max(buy, profit - price);
//            profit = Math.max(profit, buy + price);
//        }
//
//        return profit;
//    }

//    /*  One pass
//        Time complexity: O(n)
//        Space complexity: O(1)
//     */
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            if (prices[i] < prices[i + 1]) {
//                profit += prices[i + 1] - prices[i];
//            }
//        }
//
//        return profit;
//    }
}
