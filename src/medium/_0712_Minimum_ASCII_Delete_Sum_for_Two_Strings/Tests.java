package medium._0712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Memoization solutionMemoization = new Solution_Memoization();
    Solution_Dynamic_Programming solution_dynamic_programming = new Solution_Dynamic_Programming();
    Solution_Dynamic_Programming_1_D_Array solution_dynamic_programming_1_d_array = new Solution_Dynamic_Programming_1_D_Array();

    @Test
    void test1() {
        String s1 = "sea";
        String s2 = "eat";
        assertEquals(231, solutionMemoization.minimumDeleteSum(s1, s2));
        assertEquals(231, solution_dynamic_programming.minimumDeleteSum(s1, s2));
        assertEquals(231, solution_dynamic_programming_1_d_array.minimumDeleteSum(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "delete";
        String s2 = "leet";
        assertEquals(403, solutionMemoization.minimumDeleteSum(s1, s2));
        assertEquals(403, solution_dynamic_programming.minimumDeleteSum(s1, s2));
        assertEquals(403, solution_dynamic_programming_1_d_array.minimumDeleteSum(s1, s2));
    }

    @Test
    void test3() {
        String s1 = "bbccacacaa";
        String s2 = "aabccb";
        assertEquals(976, solutionMemoization.minimumDeleteSum(s1, s2));
        assertEquals(976, solution_dynamic_programming.minimumDeleteSum(s1, s2));
        assertEquals(976, solution_dynamic_programming_1_d_array.minimumDeleteSum(s1, s2));
    }
}