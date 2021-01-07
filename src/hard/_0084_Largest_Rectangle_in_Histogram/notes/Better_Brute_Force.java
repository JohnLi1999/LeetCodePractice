package hard._0084_Largest_Rectangle_in_Histogram.notes;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity: O(n^2)
        Every possible pair is considered
    Space complexity: O(1)
        No extra space is used.
 */
public class Better_Brute_Force {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
