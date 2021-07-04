package medium._0050_Pow_x_n.notes;

public class Iterative_Method {
    /*  https://en.wikipedia.org/wiki/Exponentiation_by_squaring
        Time complexity: O(log(n))
            For each bit of n's binary representation, we will at most multiply once.
            So the total time complexity is O(log(n)).
        Space complexity: O(1)
            We only need two variables for the current product and the final result of x.
     */
    public static double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -n;
            x = 1.0 / x;
        }

        /*  Explanation: in this method, we are using Binary Exponentiation
            For example, to calculate 3^11
                binary version of 11 is '1011b'
                so, 3^11 = 3^8 * 3^2 * 3^1 = 3^(2^3) * 3^(2^1) * 3^(2^0)
                we need to multiple the result by 3^(2^i) if the bit in binary version of 11 is 1
            So, how do we know whether the bit is 1 or 0?
                we know the binary number is an odd number the last bit is 1, and we
                also know divide a number by 2 is remove the last bit in its binary version.
                (e.g. (11 / 2 = 5) is equivalent to ('1011' removes last bit to '101'))
            Therefore, we will start with "result = 1, product = x".
                The current product represents 3^(2^i) in the above example.
                In each turn, we multiple product with itself ((x^{n/2})^2 = x^n),
                then we check if n is odd or even,
                if n is odd, we need to multiple result with product.
                At the end of each turn, we divide n by 2, and iterative until n < 1;
         */

        // Start with result = 1.0, and product = x
        double result = 1.0;
        double current_product = x;

        // Iterate from N to 0 (exclude 0)
        for (long i = N; i > 0; i /= 2) {
            // If i is odd, we need to update result by multiple it with product
            if (i % 2 == 1) {
                result *= current_product;
            }

            // Multiple product by itself
            current_product *= current_product;
        }

        return result;
    }
}