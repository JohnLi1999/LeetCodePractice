package easy._0122_Best_Time_to_Buy_and_Sell_Stock_II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0122_Best_Time_to_Buy_and_Sell_Stock_II.Solution.maxProfit_Peek_Valley_Approach;
import static easy._0122_Best_Time_to_Buy_and_Sell_Stock_II.Solution.maxProfit_Simple_One_Pass;

class Tests {

    Solution_Dynamic_Programming solution_dynamic_programming = new Solution_Dynamic_Programming();

    @Test
    void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(7, maxProfit_Peek_Valley_Approach(prices));
        assertEquals(7, maxProfit_Simple_One_Pass(prices));
        assertEquals(7, solution_dynamic_programming.maxProfit(prices));
    }

    @Test
    void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, maxProfit_Peek_Valley_Approach(prices));
        assertEquals(4, maxProfit_Simple_One_Pass(prices));
        assertEquals(4, solution_dynamic_programming.maxProfit(prices));
    }

    @Test
    void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, maxProfit_Peek_Valley_Approach(prices));
        assertEquals(0, maxProfit_Simple_One_Pass(prices));
        assertEquals(0, solution_dynamic_programming.maxProfit(prices));
    }
}