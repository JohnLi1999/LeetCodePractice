package medium._0050_Pow_x_n.notes;

public class Recursive_Method {
    /*  Time complexity: O(log(n))
            Each time we apply the formula (x^n)^2 = x^{2*n}, n is reduced by half.
            Thus we need at most O(log(n)) computations to get the result.
        Space complexity: O(log(n))
            For each computation, we need to store the result of x^{n/2}.
            We need to do the computation for O(log(n)) times, so the space complexity is O(log(n)).
     */
    public double myPow(double x, int n) {
        // Use long type to avoid the overflow when n = Integer.MIN_VALUE (-2147483648)
        long N = n;

        if (n < 0) {
            N = -n;
            // Use 1 / x when n < 0 since dividing floating numbers is much slower than multiplying them
            x = 1 / x;
        }

        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
