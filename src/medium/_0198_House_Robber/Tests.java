package medium._0198_House_Robber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    Solution_Memoization solutionMemoization = new Solution_Memoization();
    Solution_DP solution_dp = new Solution_DP();

    @Test
    void test1() {
        int[] nums = {9, 1, 1, 7, 1, 8, 1};
        assertEquals(24, solutionMemoization.rob(nums));
        assertEquals(24, solution_dp.rob(nums));
    }

    @Test
    void test2() {
        int[] nums = {
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };
        assertEquals(0, solutionMemoization.rob(nums));
        assertEquals(0, solution_dp.rob(nums));
    }
}