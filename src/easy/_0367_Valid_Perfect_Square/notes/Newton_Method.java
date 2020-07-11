package easy._0367_Valid_Perfect_Square.notes;

/*  Time complexity: O(log(N))
        Since the set converges quadratically.
    Space complexity: O(1)
 */
public class Newton_Method {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }

        return (x * x == num);
    }
}