package medium._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solution_my_way = new Solution_My_Way();
    Solution_Bounds solution_bounds = new Solution_Bounds();

    @Test
    void test1() {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] expected = new int[] {3, 4};
        assertArrayEquals(expected, solution_my_way.searchRange(nums, target));
        assertArrayEquals(expected, solution_bounds.searchRange(nums, target));
    }

    @Test
    void test2() {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 6;
        int[] expected = new int[] {-1, -1};
        assertArrayEquals(expected, solution_my_way.searchRange(nums, target));
        assertArrayEquals(expected, solution_bounds.searchRange(nums, target));
    }

    @Test
    void test3() {
        int[] nums = {};
        int target = 0;
        int[] expected = new int[] {-1, -1};
        assertArrayEquals(expected, solution_my_way.searchRange(nums, target));
        assertArrayEquals(expected, solution_bounds.searchRange(nums, target));
    }
}