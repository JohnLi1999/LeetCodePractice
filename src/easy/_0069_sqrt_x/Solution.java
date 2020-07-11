package easy._0069_sqrt_x;

/*  https://leetcode.com/problems/sqrtx/
    Time complexity: O(log(N))
    Space complexity: O(1)
 */
public class Solution {
    public static int mySqrt(int x) {
        // Use Binary Search
        int left = 0, right = x, mid;
        long prod;

        while (left <= right) {
            mid = (left + right) / 2;
            // To avoid overflow, we need convert the product to a long number
            prod = (long) mid * mid;

            if (prod == x) {
                return mid;
            } else if (prod < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        /*  We have (left > right) when the loop breaks. At this moment,
            right * right <= x < left * left.
            So we return right as the final result when the loop stops
         */
        return right;
    }

    /*  Might need further improvement  */
    public static double mySqrt(int x, double tolerance) {
        if (x < 2) {
            return x;
        }

        double left = 0.0;
        double right = x;
        double mid;

        while (Math.abs(left - right) > tolerance) {
            mid = (left + right) / 2;
            double prod = mid * mid;

            if (prod == x) {
                return mid;
            } else if (prod < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2;
    }
}
