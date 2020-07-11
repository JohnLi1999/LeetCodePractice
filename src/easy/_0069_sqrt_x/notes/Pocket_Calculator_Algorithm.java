package easy._0069_sqrt_x.notes;

/*  Time complexity: O(1)
    Space complexity: O(1)
 */
public class Pocket_Calculator_Algorithm {
    public int mySqrt(int x) {
        if (x < 2) return x;

        /* sqrt(x) = e^{1/2 * log(x)}
           Check more explanation in "0069. Sqrt(x).png"
         */

        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }
}