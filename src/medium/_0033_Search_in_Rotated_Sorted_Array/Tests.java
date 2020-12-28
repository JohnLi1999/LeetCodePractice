package medium._0033_Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        assertEquals(4, solution.search(nums, target));
    }

    @Test
    void test2() {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        assertEquals(-1, solution.search(nums, target));
    }

    @Test
    void test3() {
        int[] nums = { 1 };
        int target = -1;
        assertEquals(-1, solution.search(nums, target));
    }

    @Test
    void test4() {
        int[] nums = { 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7 };
        int target = 3;
        assertEquals(10, solution.search(nums, target));
    }

    @Test
    void test5() {
        int[] nums = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 1, 2, 3 };
        int target = 2;
        assertEquals(13, solution.search(nums, target));
    }   
    
    @Test
    void test6() {
        int[] nums = { 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        int target = 14;
        assertEquals(1, solution.search(nums, target));
    }    
    
    @Test
    void test7() {
        int[] nums = { 12, 13, 14, 15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int target = 1;
        assertEquals(4, solution.search(nums, target));
    }

    @Test
    void test8() {
        int[] nums = { 3, 1 };
        int target = 1;
        assertEquals(1, solution.search(nums, target));
    }

    @Test
    void test9() {
        int[] nums = { 5, 1, 3 };
        int target = 3;
        assertEquals(2, solution.search(nums, target));
    }
}