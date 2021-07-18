package hard._0123_Best_Time_to_Buy_and_Sell_Stock_III.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {3,3,5,0,0,3,1,4})); // 6
        System.out.println(s.maxProfit(new int[] {1,2,3,4,5})); // 4
        System.out.println(s.maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(s.maxProfit(new int[] {1})); // 0
    }

    /*  Time complexity: O(n)
        Space complexity: O(1)

        Basically this question is the combination of
        0121 (only 1 transaction) and 0122 (infinite transactions).

        The recurrences doubles, and now we have to track four variables:
            - buying price for the first transaction
            - profit made by the first transaction
            - buying price for the second transaction
            - profit made by the second transaction

        The goal of the first buying price is relatively simple. It is the same
        as that in 0121: we want to find the lowest price. So, the first profit is
        also the same: it is either the previous first profit or
        (current price - current first buying price).

        The second buying is similar as that in 0122: it is the cumulative buying price
        after we have made the first profit. So, the second buying price is
        (current price - first profit has been made). The second profit is also the
        cumulative profit: it is either the previous second profit or
        (current price - current second buying price).

        Therefore, here are the four recurrences:
            - buy1[i] = min(buy[i-1], price[i])
            - profit1[i] = max(profit1[i-1], price[i] - buy1[i])
            - buy2[i] = min(buy2[i-1], price[i] - profit1[i])
            - profit2[i] = max(profit2[i-1], price[i] - buy2[i])

        Two things are important:
            1. the sequence is important: we should follow the above order
            2. we always need the latest state for those variables. Note
                the buy1[i] in profit[i]
                the profit1[i] in buy2[i]
                the buy2[i] in profit2[i]
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        /*  buy1[i] = min(buy[i-1], price[i])
            profit1[i] = max(profit1[i-1], price[i] - buy1[i])
            buy2[i] = min(buy2[i-1], price[i] - profit1[i])
            profit2[i] = max(profit2[i-1], price[i] - buy2[i])
         */
        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }
}
