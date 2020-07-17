package easy._0231_Power_of_Two;

public class Solution {
    /*  https://leetcode.com/problems/power-of-two/
        Time complexity: O(1)
        Space complexity: O(1)
     */
    public static boolean isPowerOfTwo_Turn_off_the_Rightmost_1_Bit(int n) {
        if (n == 0) { // return false for the special case 0
            return false;
        }

        long x = n; // use Long to avoid overflow
        return (x & (x - 1)) == 0;
    }

    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public static boolean isPowerOfTwo_Get_the_Rightmost_1_Bit(int n) {
        if (n == 0) { // return false for the special case 0
            return false;
        }

        long x = n; // use Long to avoid overflow
        return (x & -x) == x;
    }

    /*  Time complexity: O(log(n))
        Space complexity: O(1)
     */
    public static boolean isPowerOfTwo_Simple_Way(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
