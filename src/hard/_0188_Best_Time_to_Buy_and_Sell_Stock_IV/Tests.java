package hard._0188_Best_Time_to_Buy_and_Sell_Stock_IV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] prices = {2, 4, 1};
        int k = 2;
        assertEquals(2, solution.maxProfit(k, prices));
    }

    @Test
    void test2() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        assertEquals(7, solution.maxProfit(k, prices));
    }
}