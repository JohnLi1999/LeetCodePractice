package medium._0547_Friend_Circles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[][] M = {   {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}   };
        assertEquals(2, solution.findCircleNum(M));
    }

    @Test
    void test2() {
        int[][] M = {   {1, 1, 0},
                        {1, 1, 1},
                        {0, 1, 1}   };
        assertEquals(1, solution.findCircleNum(M));
    }

    @Test
    void test3() {
        int[][] M = {   {1, 1, 0, 1},
                        {1, 1, 0, 1},
                        {0, 0, 1, 0},
                        {0, 1, 0, 1}   };
        assertEquals(2, solution.findCircleNum(M));
    }
}