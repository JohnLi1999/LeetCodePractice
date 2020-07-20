package medium._0152_Maximum_Product_Subarray;

import medium._0152_Maximum_Product_Subarray.notes.Solution_Dynamic_Programming;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Dynamic_Programming solution_dynamic_programming = new Solution_Dynamic_Programming();
    Solution_Brute_Force solution_brute_force = new Solution_Brute_Force();

    @Test
    void test1() {
        int[] input = {2, 3, -2, 4};
        assertEquals(6, solution_dynamic_programming.maxProduct(input));
        assertEquals(6, solution_brute_force.maxProduct(input));
    }

    @Test
    void test2() {
        int[] input = {-2, 0, -1};
        assertEquals(0, solution_dynamic_programming.maxProduct(input));
        assertEquals(0, solution_brute_force.maxProduct(input));
    }

    @Test
    void test3() {
        int[] input = {2, -5, 3, 1, -4, 0, -10, 2, 8};
        assertEquals(120, solution_dynamic_programming.maxProduct(input));
        assertEquals(120, solution_brute_force.maxProduct(input));
    }
}