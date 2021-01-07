package hard._0084_Largest_Rectangle_in_Histogram.notes;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity: O(n^3)
        We have to find the minimum height bar O(n) lying between every pair O(n^2)
    Space complexity : O(1)
        Constant space is used.
 */
public class Brute_Force {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }
}
