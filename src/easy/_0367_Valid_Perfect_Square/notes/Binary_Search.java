package easy._0367_Valid_Perfect_Square.notes;

/*  Time complexity: O(log(N))
        Let's compute time complexity with the help of master theorem T(N) = aT(N/b) + Θ(N^d).
        The equation represents dividing the problem up into a sub-problems of size (N/b) in Θ(N^d) time.
        Here at step there is only one sub-problem a = 1, its size is a half of the initial problem b = 2,
        and all this happens in a constant time d = 0. That means that log_b{a} = d and hence
        we're dealing with case 2 that results in O(n^{log_b{a}} * log^{d+1} * N) = O(log(N)) time complexity.
    Space complexity: O(1)
 */
public class Binary_Search {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }

        return false;
    }
}