package medium._0714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        assertEquals(8, solution.maxProfit(prices, fee));
    }
}