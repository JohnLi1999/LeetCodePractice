package easy._0122_Best_Time_to_Buy_and_Sell_Stock_II.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {7,1,5,3,6,4})); // 7
        System.out.println(s.maxProfit(new int[] {1,2,3,4,5})); // 4
        System.out.println(s.maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(s.maxProfit(new int[] {1})); // 0
    }

    /*  Dynamic Programming
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MIN_VALUE;

        /*  buy[i] = max(buy[i - 1], profit[i - 1] - price[i])
            profit[i] = max(profit[i - 1], buy[i] + prices[i])
         */

        for (int price : prices) {
            buy = Math.max(buy, profit - price);
            profit = Math.max(profit, buy + price);
        }

        return profit;
    }

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
