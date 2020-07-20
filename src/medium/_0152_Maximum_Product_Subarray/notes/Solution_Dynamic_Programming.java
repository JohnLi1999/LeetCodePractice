package medium._0152_Maximum_Product_Subarray.notes;

public class Solution_Dynamic_Programming {
    /*  https://leetcode.com/problems/maximum-product-subarray/
        Time complexity: O(N)
            Where N is the size of nums. The algorithm achieves linear runtime since
            we are going through nums only once.
        Space complexity: O(1)
            Since no additional space is consumed rather than variables which keep track of
            the maximum product so far, the minimum product so far, current variable, temp variable,
            and placeholder variable for the result.
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int curr_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = curr_max;

            if (max_so_far > result) {
                result = max_so_far;
            }
        }

        return result;
    }
}
