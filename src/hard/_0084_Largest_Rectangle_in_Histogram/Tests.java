package hard._0084_Largest_Rectangle_in_Histogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way solution_my_way = new Solution_My_Way();
    Solution_Stack solution_stack = new Solution_Stack();
    Solution_Divide_and_Conquer solution_divide_and_conquer = new Solution_Divide_and_Conquer();

    @Test
    void test1() {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        assertEquals(10, solution_my_way.largestRectangleArea(heights));
        assertEquals(10, solution_stack.largestRectangleArea(heights));
        assertEquals(10, solution_divide_and_conquer.largestRectangleArea(heights));
    }

    @Test
    void test2() {
        int[] heights = { 2, 4, };
        assertEquals(4, solution_my_way.largestRectangleArea(heights));
        assertEquals(4, solution_stack.largestRectangleArea(heights));
        assertEquals(4, solution_divide_and_conquer.largestRectangleArea(heights));
    }

    @Test
    void test3() {
        int[] heights = { 2, 0, 2};
        assertEquals(2, solution_my_way.largestRectangleArea(heights));
        assertEquals(2, solution_stack.largestRectangleArea(heights));
        assertEquals(2, solution_divide_and_conquer.largestRectangleArea(heights));
    }
}