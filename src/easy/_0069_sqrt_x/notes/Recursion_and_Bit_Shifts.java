package easy._0069_sqrt_x.notes;

/*  Time complexity: O(log(N))
        Let's compute time complexity with the help of master theorem T(N) = aT(N/b) + Θ(N^d).
        The equation represents dividing the problem up into a sub-problems of size (N/b) in Θ(N^d) time.
        Here at step there is only one sub-problem a = 1, its size is a half of the initial problem b = 2,
        and all this happens in a constant time d = 0. That means that log_b{a} = d and hence
        we're dealing with case 2 that results in O(n^{log_b{a}} * log^{d+1} * N) = O(log(N)) time complexity.
    Space complexity: O(log(N))
        To keep the recursion stack.
 */
public class Recursion_and_Bit_Shifts {
    public int mySqrt(int x) {
        if (x < 2) return x;

        /*  sqrt(x) = 2 * sqrt(x / 4)
            x >> 2 => x / 4
            mySqrt(x >> 2) => mySqrt(x / 4)
            mySqrt(x >> 2) << 1 => 2 * mySqrt(x / 4) => mySqrt(x)
            Check more explanation in "0069. Sqrt(x).png"
         */

        int left = mySqrt(x >> 2) << 1;

        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}