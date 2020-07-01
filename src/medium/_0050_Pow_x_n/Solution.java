package medium._0050_Pow_x_n;

public class Solution {
    /*  https://leetcode.com/problems/powx-n/
        Time complexity: O(log(n))
            Each time we apply the formula (x^n)^2 = x^{2*n}, n is reduced by half.
            Thus we need at most O(log(n)) computations to get the result.
        Space complexity: O(log(n))
            For each computation, we need to store the result of x^{n/2}.
            We need to do the computation for O(log(n)) times, so the space complexity is O(log(n)).
     */
    public static double myPow_Recursive(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double tempResult = myPow_Recursive(x, n / 2);

        if (n % 2 == 0) {
            return tempResult * tempResult;
        } else if (n > 0) {
            return tempResult * tempResult * x;
        } else {
            return tempResult * tempResult / x;
        }
    }
}
