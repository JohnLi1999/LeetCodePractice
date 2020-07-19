package medium._0120_Triangle;

import java.util.List;

/*  https://leetcode.com/problems/triangle/
    Time Complexity: O(2^n)
        Where n the number of rows in the triangle
    Space Complexity: O(n)
        N is the number of callbacks in the recursion
 */
public class Solution_BruteForce {
    private List<List<Integer>> triangle;
    private int[] result = {Integer.MAX_VALUE}; // To save the minimum sum

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;

        backtrack(0, 0, 0);

        return result[0];
    }

    /*  Backtrack for all possible sums */
    private void backtrack(int level, int index, int temp) {
        temp += triangle.get(level).get(index);

        if (level == triangle.size() - 1) {
            if (temp < result[0]) {
                result[0] = temp;
            }
            return;
        }

        backtrack(level + 1, index, temp);
        backtrack(level + 1, index + 1, temp);
    }
}
