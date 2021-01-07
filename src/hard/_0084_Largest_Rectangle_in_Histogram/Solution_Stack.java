package hard._0084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity: O(n)
        N numbers are pushed and popped.
    Space complexity: O(n)
        Stack is used.
 */
public class Solution_Stack {
    public int largestRectangleArea(int[] heights) {
        return betterWay(heights);
//        return sampleSolution(heights);
    }

    private int betterWay(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int maxArea = 0;

        for (int i = 0; i <= len; i++) {
            while (!stack.isEmpty() && (i == len || heights[i] <= heights[stack.peek()])) {
                int height = heights[stack.pop()];
                /*  If stack is empty, it means we just pop out the smallest element
                    So, the width is the length of the heights array  */
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    private int sampleSolution(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        // Push -1 to the bottom of the stack as the left boundary limit
        stack.push(-1);
        // Initialize the max area to 0
        int maxArea = 0;

        /*  We will traverse all heights and do the following operations
                1.  we want all the elements that have been pushed into the
                    stack have an ascending order. We do not record the height itself
                    in the stack and we record their indices instead.
                2.  If we meet an element that is smaller or equal to the
                    top element in the stack and the top element is not the
                    left boundary limit (-1), we need to pop some elements out.
                3.  When situation in step 2 happens, we will do the following operations
                    3.1.    Record the current index as the right limit
                    3.2.    Pop out the top element in the stack, and this element represent
                            the index in the given heights array. So we can find the corresponding
                            height and mark it as current height
                    3.3.    Peek the next top element in the stack, and this element will
                            be the left limit.
                    3.4.    We calculate (right_limit - left_limit + 1), and this is the width to
                            form the new area. We call it current width
                    3.5.    The new area is current_height * current width
                    3.6.    Compare the max area found so far with the new area, and update
                            max area if the new area is larger
                4.  Repeat step 2 and step 3 until we find an element that is larger than the
                    stack top or all element (except left boundary limit, -1) are popped out
                5.  If we meet left boundary limit (-1) or the current element is larger
                    than stack top, we directly add its index into stack. Then keep traversing
                    the rest of heights array
         */
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }

        /*  Once we have traversed all elements in the stack array, we need to
            check if there is any element left in the stack (except left boundary limit, -1).
            If there are those elements, we need to do the following operations:
                1.  If the stack top is not left boundary limit -1,
                    we pop out the top element and find the corresponding height.
                    This height is the current height
                2.  The way to find the current width is a little different.
                    We have to know that since we have reached the end of the heights
                    array, it means the elements left in ths stack are the minimum heights
                    So they keep in the valid state until the end. Thus, the right limit
                    is always the length of the heights array.
                    The left limit is usual. It is the next top element in the stack.
                    Now we calculate (right_limit - left_limit + 1), and this is the width to
                    form the new area. We call it current width
                3.  The new area is current_height * current width. We then compare
                    the max area found so far with the new area, and update
                    max area if the new area is larger
                x.  Keep repeating previous steps until
                    the stack top is left boundary limit -1.
         */
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;
    }
}
