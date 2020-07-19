package medium._0120_Triangle;

import java.util.List;

public class Solution_Top_Down {
    /*  https://leetcode.com/problems/triangle/
        Time Complexity: O(n^2)
            Where n the number of rows in the triangle
        Space Complexity: O(n^2)
            We use a 2-D array to save the temporal minimum sums
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.get(triangle.size() - 1).size();
        // Use a 2D array to save minimum sums in each level
        int[][] minSums = new int[length][length];
        // Save the first value
        minSums[0][0] = triangle.get(0).get(0);

        /*  Start from the top level in the triangle.
            Iterate all levels down to the last one.
            Save temporal minimum sums in the minSums  */
        for (int level = 1; level < triangle.size(); level++) {
            for (int index = 0; index < triangle.get(level).size(); index++) {
                int curr = triangle.get(level).get(index);

                // Corner case for the head and tail elements in the level
                if (index == 0) {
                    minSums[level][index] = curr + minSums[level - 1][index];
                } else if (index == triangle.get(level).size() - 1) {
                    minSums[level][index] = curr + minSums[level - 1][index - 1];
                } else {
                    /*  Compare the left and right possible values, and
                        choose the smaller one to form the new sum  */
                    int left = minSums[level - 1][index - 1];
                    int right = minSums[level - 1][index];
                    minSums[level][index] = curr + Math.min(left, right);
                }
            }
        }

        // Search the last level in the minSums, and return the minimum value
        int result = Integer.MAX_VALUE;
        for (int num : minSums[length - 1]) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }
}
