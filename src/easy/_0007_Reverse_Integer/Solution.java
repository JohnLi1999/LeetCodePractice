package easy._0007_Reverse_Integer;

public class Solution {
    /*  https://leetcode.com/problems/reverse-integer/
        Time Complexity: O(log(x))
            There are roughly log(x) (base 10) digits in x.
        Space Complexity: O(1)
     */
    public static int reverse(int x) {
        int result = 0;
        int upperBound = Integer.MAX_VALUE / 10;
        int lowerBound = Integer.MIN_VALUE / 10;

        while (x != 0) {
            // Overflow Check
            if (result > upperBound ||
                result == upperBound && x % 10 > Integer.MAX_VALUE % 10 ||
                result < lowerBound ||
                result == lowerBound && x % 10 < Integer.MIN_VALUE % 10) {
                return 0;
            }

            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
