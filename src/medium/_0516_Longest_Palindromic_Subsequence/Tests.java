package medium._0516_Longest_Palindromic_Subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Memoization solutionMemoization = new Solution_Memoization();
    Solution_DP solution_dp = new Solution_DP();

    @Test
    void test1() {
        String s = "bbbab";
        assertEquals(4, solutionMemoization.longestPalindromeSubseq(s));
        assertEquals(4, solution_dp.longestPalindromeSubseq(s));
    }

    @Test
    void test2() {
        String s = "cbbd";
        assertEquals(2, solutionMemoization.longestPalindromeSubseq(s));
        assertEquals(2, solution_dp.longestPalindromeSubseq(s));
    }
}