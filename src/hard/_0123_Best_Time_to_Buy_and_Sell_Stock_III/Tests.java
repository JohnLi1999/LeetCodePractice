package hard._0123_Best_Time_to_Buy_and_Sell_Stock_III;

import org.junit.jupiter.api.Test;

import static hard._0123_Best_Time_to_Buy_and_Sell_Stock_III.Solution.maxProfit;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int[] input = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, maxProfit(input));
    }

    @Test
    void test2() {
        int[] input = {1, 2, 3, 4, 5};
        assertEquals(4, maxProfit(input));
    }

    @Test
    void test3() {
        int[] input = {7, 6, 4, 3, 1};
        assertEquals(0, maxProfit(input));
    }

    @Test
    void test4() {
        int[] input = {2, 8, 1, 4, 6, 3, 9};
        assertEquals(14, maxProfit(input));
    }
}