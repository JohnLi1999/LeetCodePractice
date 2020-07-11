package easy._0069_sqrt_x.notes;

/*  Time complexity: O(log(N))
        Since the set converges quadratically.
    Space complexity: O(1)
 */
public class Newton_Method {
    public int mySqrt(int x) {
        if (x < 2) return x;

        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }

        return (int) x1;
    }
}