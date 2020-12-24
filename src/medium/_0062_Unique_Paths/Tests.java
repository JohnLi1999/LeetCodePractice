package medium._0062_Unique_Paths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int m = 3, n = 7;
        assertEquals(28, solution.uniquePaths(m, n));
    }

    @Test
    void test2() {
        int m = 3, n = 2;
        assertEquals(3, solution.uniquePaths(m, n));
    }

    @Test
    void test3() {
        int m = 7, n = 3;
        assertEquals(28, solution.uniquePaths(m, n));
    }

    @Test
    void test4() {
        int m = 3, n = 3;
        assertEquals(6, solution.uniquePaths(m, n));
    }
}