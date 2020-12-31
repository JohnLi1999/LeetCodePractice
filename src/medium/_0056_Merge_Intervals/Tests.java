package medium._0056_Merge_Intervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solution_my_way = new Solution_My_Way();
    Solution_Better solution_better = new Solution_Better();

    @Test
    void test1() {
        int[][] intervals = {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        };
        int[][] expectedResult = {
                { 1, 6 }, { 8, 10 }, { 15, 18 }
        };
        assertArrayEquals(expectedResult, solution_my_way.merge(intervals));
        assertArrayEquals(expectedResult, solution_better.merge(intervals));
    }

    @Test
    void test2() {
        int[][] intervals = {
                { 1, 4 }, { 4, 5 }
        };
        int[][] expectedResult = {
                { 1, 5 }
        };
        assertArrayEquals(expectedResult, solution_my_way.merge(intervals));
        assertArrayEquals(expectedResult, solution_better.merge(intervals));
    }

    @Test
    void test3() {
        int[][] intervals = {
                { 1, 4 }, { 4, 3 }
        };
        int[][] expectedResult = {
                { 1, 4 }
        };
        assertArrayEquals(expectedResult, solution_my_way.merge(intervals));
        assertArrayEquals(expectedResult, solution_better.merge(intervals));
    }
}