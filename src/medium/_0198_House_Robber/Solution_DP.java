package medium._0198_House_Robber;

/*  https://leetcode.com/problems/house-robber/
    Time complexity: O(n)
        We used cache array to save results, so it is linear time complexity.
 */
public class Solution_DP {
    public int rob(int[] nums) {
        return dp_variables(nums);
//        return dp_array(nums);
    }

    /*  Space complexity: O(1)
            We only use three variables to save the previous results, so it is constant time complexity
     */
    public int dp_variables(int[] nums) {
        int num1 = 0, num2 = 0, temp;

        for (int n : nums) {
            if (n + num1 > num2) {
                temp = num2;
                num2 = num1 + n;
                num1 = temp;
            } else {
                num1 = num2;
            }
        }

        return num2;
    }

    /*  Space complexity: O(n)
            We only use the dp array, so it is linear time complexity
     */
    public int dp_array(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
