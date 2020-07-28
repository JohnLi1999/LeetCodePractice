package medium._0322_Coin_Change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Dynamic_Programming solutionDynamicProgramming = new Solution_Dynamic_Programming();
    Solution_Brute_Force solution_brute_force = new Solution_Brute_Force();

    @Test
    void test1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        assertEquals(3, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(3, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(3, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test2() {
        int[] coins = {2};
        int amount = 3;
        assertEquals(-1, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(-1, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(-1, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test3() {
        int[] coins = {1, 9, 10};
        int amount = 18;
        assertEquals(2, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(2, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(2, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test4() {
        int[] coins = {2, 9, 10};
        int amount = 18;
        assertEquals(2, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(2, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(2, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test5() {
        int[] coins = {2, 9, 10};
        int amount = 20;
        assertEquals(2, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(2, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(2, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test6() {
        int[] coins = {1};
        int amount = 0;
        assertEquals(0, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(0, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(0, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test7() {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        assertEquals(20, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(20, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(20, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test8() {
        int[] coins = {346, 29, 395, 188, 155, 109};
        int amount = 9401;
        assertEquals(26, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(26, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(26, solution_brute_force.coinChange(coins, amount));
    }

    @Test
    void test9() {
        int[] coins = {2};
        int amount = 1;
        assertEquals(-1, solutionDynamicProgramming.coinChange_Better_Way(coins, amount));
        assertEquals(-1, solutionDynamicProgramming.coinChange(coins, amount));
        assertEquals(-1, solution_brute_force.coinChange(coins, amount));
    }
}