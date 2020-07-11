package easy._0367_Valid_Perfect_Square;

/*  https://leetcode.com/problems/valid-perfect-square/
    Time complexity: O(log(N))
    Space complexity: O(1)
 */
public class Solution {
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 0, right = num, mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if ((mid == num / mid)) {
                return num % mid == 0;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
