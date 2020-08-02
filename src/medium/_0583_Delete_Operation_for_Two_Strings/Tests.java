package medium._0583_Delete_Operation_for_Two_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Dynamic_Programming solutionDynamicProgramming = new Solution_Dynamic_Programming();
    Solution_LCS_Dynamic_Programming solution_lcs_dynamic_programming = new Solution_LCS_Dynamic_Programming();

    @Test
    void test1() {
        String word1 = "sea";
        String word2 = "eat";
        assertEquals(2, solutionDynamicProgramming.minDistance(word1, word2));
        assertEquals(2, solution_lcs_dynamic_programming.minDistance(word1, word2));
    }

    @Test
    void test2() {
        String word1 = "sea";
        String word2 = "ate";
        assertEquals(4, solutionDynamicProgramming.minDistance(word1, word2));
        assertEquals(4, solution_lcs_dynamic_programming.minDistance(word1, word2));
    }

    @Test
    void test3() {
        String word1 = "";
        String word2 = "a";
        assertEquals(1, solutionDynamicProgramming.minDistance(word1, word2));
        assertEquals(1, solution_lcs_dynamic_programming.minDistance(word1, word2));
    }
}