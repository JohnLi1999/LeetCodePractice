package medium._0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {1,3,2,8,4,9}, 2)); // 8
        System.out.println(s.maxProfit(new int[] {1,3,7,5,10,3}, 3)); // 6
    }

    /*  Time complexity: O(n)
        Space complexity: O(1)
     */
    public int maxProfit(int[] prices, int fee) {
        /*  buy[i] = min(buy[i], price[i] - profit[i - 1])
            profit[i] = max(profit[i - 1], price[i] - buy[i] - fee)
         */

        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            buy = Math.min(buy, price - profit);
            profit = Math.max(profit, price - buy - fee);
        }

        return profit;
    }
}
