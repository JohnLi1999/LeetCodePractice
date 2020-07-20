package medium._0152_Maximum_Product_Subarray;

public class Solution_Brute_Force {
    /*  https://leetcode.com/problems/maximum-product-subarray/
        Time complexity: O(N^2)
            Where N is the size of nums. Since we are checking every possible contiguous subarray
            following every element in nums we have quadratic runtime.
        Space complexity: O(1)
            Since we are not consuming additional space other than two variables:
            result to hold the final result and product to accumulate product of preceding contiguous sub-arrays.
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product > result) {
                    result = product;
                }
            }
        }

        return result;
    }
}
