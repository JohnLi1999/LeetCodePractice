package easy._0070_Climbing_Stairs;

public class Solution {
    /*  https://leetcode.com/problems/climbing-stairs/
        Time complexity: O(n)
            Single loop upto n.
        Space complexity: O(n)
            DP_Bottom_Up array of size n is used.
     */
    public static int climbStairs_Dynamic_Programming(int n) {
        if (n < 3) {
            return n;
        }

        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];
    }

    /*  Time complexity: O(n)
            Single loop upto n is required to calculate nth fibonacci number.
        Space complexity: O(1)
            Constant space is used.
     */
    public static int climbStairs_DP_Fib(int n) {
        if (n < 3) {
            return n;
        }

        int result = 0;
        int one_step_before = 1;
        int two_steps_before = 2;

        for (int i = 3; i <= n; i++) {
            result = one_step_before + two_steps_before;
            one_step_before = two_steps_before;
            two_steps_before = result;
        }

        return result;
    }
}
