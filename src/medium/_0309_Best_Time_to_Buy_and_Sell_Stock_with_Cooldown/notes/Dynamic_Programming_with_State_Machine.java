package medium._0309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown.notes;

public class Dynamic_Programming_with_State_Machine {
    /*  Time Complexity: O(N)
            Where N is the length of the input price list.
            We have one loop over the input list, and the operation within one iteration takes constant time.
        Space Complexity: O(1)
            Constant memory is used regardless the size of the input.
     */
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }
}
