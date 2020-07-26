package easy._0121_Best_Time_to_Buy_and_Sell_Stock;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0121_Best_Time_to_Buy_and_Sell_Stock.Solution_Dynamic_Programming.maxProfit_With_Extra_Space;
import static easy._0121_Best_Time_to_Buy_and_Sell_Stock.Solution_Dynamic_Programming.maxProfit;
import static easy._0121_Best_Time_to_Buy_and_Sell_Stock.Solution.maxProfit_BruteForce;
import static easy._0121_Best_Time_to_Buy_and_Sell_Stock.Solution.maxProfit_OnePass;

class Tests {

    @Nested
    class Dynamic_Programming {
        @Test
        void test1() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            assertEquals(5, maxProfit(prices));
        }

        @Test
        void test2() {
            int[] prices = {7, 6, 4, 3, 1};
            assertEquals(0, maxProfit(prices));
        }

        @Test
        void test3() {
            int[] prices = {2, 8, 1, 4, 6, 3};
            assertEquals(6, maxProfit(prices));
        }

        @Test
        void test4() {
            int[] prices = {2, 8, 1, 4, 6, 3, 9};
            assertEquals(8, maxProfit(prices));
        }
    }

    @Nested
    class Dynamic_Programming_With_Extra_Space {
        @Test
        void test1() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            assertEquals(5, maxProfit_With_Extra_Space(prices));
        }

        @Test
        void test2() {
            int[] prices = {7, 6, 4, 3, 1};
            assertEquals(0, maxProfit_With_Extra_Space(prices));
        }

        @Test
        void test3() {
            int[] prices = {2, 8, 1, 4, 6, 3};
            assertEquals(6, maxProfit_With_Extra_Space(prices));
        }

        @Test
        void test4() {
            int[] prices = {2, 8, 1, 4, 6, 3, 9};
            assertEquals(8, maxProfit_With_Extra_Space(prices));
        }
    }

    @Nested
    class One_Pass {
        @Test
        void test1() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            assertEquals(5, maxProfit_OnePass(prices));
        }

        @Test
        void test2() {
            int[] prices = {7, 6, 4, 3, 1};
            assertEquals(0, maxProfit_OnePass(prices));
        }

        @Test
        void test3() {
            int[] prices = {2, 8, 1, 4, 6, 3};
            assertEquals(6, maxProfit_OnePass(prices));
        }

        @Test
        void test4() {
            int[] prices = {2, 8, 1, 4, 6, 3, 9};
            assertEquals(8, maxProfit_OnePass(prices));
        }
    }

    @Nested
    class Brute_Force {
        @Test
        void test1() {
            int[] prices = {7, 1, 5, 3, 6, 4};
            assertEquals(5, maxProfit_BruteForce(prices));
        }

        @Test
        void test2() {
            int[] prices = {7, 6, 4, 3, 1};
            assertEquals(0, maxProfit_BruteForce(prices));
        }

        @Test
        void test3() {
            int[] prices = {2, 8, 1, 4, 6, 3};
            assertEquals(6, maxProfit_BruteForce(prices));
        }

        @Test
        void test4() {
            int[] prices = {2, 8, 1, 4, 6, 3, 9};
            assertEquals(8, maxProfit_BruteForce(prices));
        }
    }
}