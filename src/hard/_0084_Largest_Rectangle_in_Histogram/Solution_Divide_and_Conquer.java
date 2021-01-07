package hard._0084_Largest_Rectangle_in_Histogram;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity:
        Average Case: O(n*log(n))
        Worst Case: O(n^2)
        If the numbers in the array are sorted, we don't gain the advantage of divide and conquer
    Space complexity: O(n)
        Recursion with worst case depth n
 */
/** This method exceeds the time limit */
public class Solution_Divide_and_Conquer {
    public int largestRectangleArea(int[] heights) {
        return findMax(heights, 0, heights.length - 1);
    }

    private int findMax(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }

        int minHeightIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[minHeightIndex]) {
                minHeightIndex = i;
            }
        }

        return Math.max(
                heights[minHeightIndex] * (end - start + 1),
                Math.max(
                        findMax(heights, start, minHeightIndex - 1),
                        findMax(heights, minHeightIndex + 1, end)
                )
        );
    }
}
