package hard._0407_Trapping_Rain_Water_II;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Try solution_my_try = new Solution_My_Try();
    Solution_Sample solution_sample = new Solution_Sample();

    @Test
    void test1() {
        int[][] heightMap = new int[][] {
                { 1, 4, 3, 1, 3, 2 }, 
                { 3, 2, 1, 3, 2, 4 }, 
                { 2, 3, 3, 2, 3, 1 }
        };
        assertEquals(4, solution_my_try.trapRainWater(heightMap));
        assertEquals(4, solution_sample.trapRainWater(heightMap));
    }

    @Test
    void test2() {
        int[][] heightMap = new int[][] {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 3, 1, 2, 4, 3, 1 },
                { 2, 3, 3, 2, 3, 1 }
        };
        assertEquals(7, solution_my_try.trapRainWater(heightMap));
        assertEquals(7, solution_sample.trapRainWater(heightMap));
    }

    @Test
    void test3() {
        int[][] heightMap = new int[][] {
                { 1, 4, 3, 4, 3, 2 },
                { 3, 2, 1, 1, 4, 4 },
                { 3, 1, 2, 1, 5, 1 },
                { 3, 1, 2, 1, 6, 1 },
                { 2, 3, 3, 5, 3, 1 }
        };
        assertEquals(15, solution_my_try.trapRainWater(heightMap));
        assertEquals(15, solution_sample.trapRainWater(heightMap));
    }

    @Test
    void test4() {
        int[][] heightMap = new int[][] {
                { 2, 2, 2 },
                { 2, 1, 2 },
                { 2, 1, 2 },
                { 2, 1, 2 },
        };
        assertEquals(0, solution_my_try.trapRainWater(heightMap));
        assertEquals(0, solution_sample.trapRainWater(heightMap));
    }
    
    @Test
    void test5() {
        int[][] heightMap = new int[][] {
                { 5, 8, 7, 7 },
                { 5, 2, 1, 5 },
                { 7, 1, 7, 1 },
                { 8, 9, 6, 9 },
                { 9, 8, 9, 9 } 
        };
        assertEquals(12, solution_my_try.trapRainWater(heightMap));
        assertEquals(12, solution_sample.trapRainWater(heightMap));
    }
}