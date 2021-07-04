package medium._0050_Pow_x_n.round_2;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.myPow(2.00000, 10));
        System.out.println(s.myPow(2.10000, 3));
        System.out.println(s.myPow(2.00000, -2));
        System.out.println(s.myPow(2.00000, -2147483648));

        System.out.println(s.myPow_Iterative(2.00000, 10));
        System.out.println(s.myPow_Iterative(2.10000, 3));
        System.out.println(s.myPow_Iterative(2.00000, -2));
        System.out.println(s.myPow_Iterative(2.00000, -2147483648));
    }

    /*  Bit Exponentiation: the iterative solution
        Time complexity: O(log(n))
        Space complexity: O(1)
     */
    public double myPow_Iterative(double x, int n) {
        double base = x;
        long exp = n;
        if (n < 0) {
            base = 1.0 / x;
            exp = -exp;
        }

        double result = 1.0;
        double product = base;

        for (long i = exp; i > 0; i /= 2) {
            if (i % 2 != 0) {
                result *= product;
            }
            product *= product;
        }

        return result;
    }


    /*  Recursively store half of results and reduce the calculation time
        Time complexity: O(log(n))
        Space complexity: O(log(n))
            log(n) is maximums call stack for the recursion
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / pow(x, -n);
        }
        return pow(x, n);
    }

    /*  Be careful with the type of input n. We need to use long type
        to avoid the large integer case (e.g. -2147483648 -> 2147483648) */
    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = pow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }
        return x * half * half;
    }
}
