package medium._0120_Triangle;

import java.util.List;

public class Solution_Bottom_Up {
    /*  https://leetcode.com/problems/triangle/
        Time Complexity: O(n^2)
            Where n the number of rows in the triangle
        Space Complexity: O(n)
            We use an 1-D array to save the temporal minimum sums
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start minSums as the last level in the triangle
        int[] minSums = triangle.get(triangle.size() - 1).stream().mapToInt(i -> i).toArray();

        /*  Start from the bottom level in the triangle.
            Iterate all levels up to the top one
            Save temporal minimum sums in the minSums  */
        for (int level = triangle.size() - 2; level >= 0; level--) {
            for (int index = 0; index <= level; index++) {
                // We save the updated sums back to the minSums array at the properly index
                minSums[index] = triangle.get(level).get(index) + Math.min(minSums[index], minSums[index + 1]);
            }
        }

        // The first value in the minSums array is the final answer
        return minSums[0];
    }
}
