package hard._0072_Edit_Distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Memoization solution_memoization = new Solution_Memoization();
    Solution_Dynamic_Programming_Bottom_Up solution_dynamic_programming_bottom_up = new Solution_Dynamic_Programming_Bottom_Up();
    Solution_Dynamic_Programming_1_D_Array solution_dynamic_programming_1_d_array = new Solution_Dynamic_Programming_1_D_Array();

    @Test
    void test1() {
        String word1 = "horse";
        String word2 = "ros";
        assertEquals(3, solution_memoization.minDistance(word1, word2));
        assertEquals(3, solution_dynamic_programming_bottom_up.minDistance(word1, word2));
        assertEquals(3, solution_dynamic_programming_1_d_array.minDistance(word1, word2));
    }

    @Test
    void test2() {
        String word1 = "intention";
        String word2 = "execution";
        assertEquals(5, solution_memoization.minDistance(word1, word2));
        assertEquals(5, solution_dynamic_programming_bottom_up.minDistance(word1, word2));
        assertEquals(5, solution_dynamic_programming_1_d_array.minDistance(word1, word2));
    }
}