package hard._0052_N_Queens_II;

import org.junit.jupiter.api.Test;

import static hard._0052_N_Queens_II.Solutions.totalNQueens;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_Bitwise solution_bitwise = new Solution_Bitwise();

    @Test
    void test1() {
        int n = 2;
        assertEquals(0, totalNQueens(n));
        assertEquals(0, solution_bitwise.totalNQueens(n));
    }

    @Test
    void test2() {
        int n = 4;
        assertEquals(2, totalNQueens(n));
        assertEquals(2, solution_bitwise.totalNQueens(n));
    }

    @Test
    void test3() {
        int n = 8;
        assertEquals(92, totalNQueens(n));
        assertEquals(92, solution_bitwise.totalNQueens(n));
    }
}