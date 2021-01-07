package hard._0084_Largest_Rectangle_in_Histogram.notes;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity:
        Average Case: O(n*log(n))
        Worst Case: O(n^2)
        If the numbers in the array are sorted, we don't gain the advantage of divide and conquer
    Space complexity: O(n)
        Recursion with worst case depth n
 */
public class Divide_and_Conquer {
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(
                heights[minindex] * (end - start + 1),
                Math.max(
                        calculateArea(heights, start, minindex - 1),
                        calculateArea(heights, minindex + 1, end)
                )
        );
    }
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}