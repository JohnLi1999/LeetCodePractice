package easy._0121_Best_Time_to_Buy_and_Sell_Stock.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {7,1,5,3,6,4})); // 5
        System.out.println(s.maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(s.maxProfit(new int[] {2,1,2,0,1})); // 1
    }

    /*  Dynamic Programming
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        /*  Recurrence:
            1. buy[i] = min(buy[i - 1], prices[i]);
            2. profit[i] = max(profit[i - 1], prices[i] - buy[i])

            Explanation:
            1: keep track for the minimum available price to buy
            2: maximum profit is either
                the maximum profit achieved before or
                the profit made by the current price and current minimum buying price
         */

        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }

        return profit;
    }

//    /*  Improved one pass
//        Time complexity: O(n)
//        Space complexity: O(1)
//     */
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//
//        for (int price : prices) {
//            minPrice = Math.min(minPrice, price);
//            maxProfit = Math.max(maxProfit, price - minPrice);
//        }
//
//        return maxProfit;
//    }

//    /*  Search for peak and valley
//        Time complexity: O(n)
//        Space complexity: O(1)
//     */
//    public int maxProfit(int[] prices) {
//        int peak;
//        int valley = Integer.MAX_VALUE;
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            if (i != prices.length - 1 && prices[i] < prices[i + 1]) {
//                valley = Math.min(valley, prices[i]);
//            }
//            if (i == prices.length - 1 || prices[i] > prices[i + 1]) {
//                peak = prices[i];
//                maxProfit = Math.max(maxProfit, peak - valley);
//            }
//        }
//
//        return maxProfit;
//    }
}
