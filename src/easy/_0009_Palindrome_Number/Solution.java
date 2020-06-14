package easy._0009_Palindrome_Number;

public class Solution {
    /*  https://leetcode.com/problems/palindrome-number/
        Time Complexity: O(log(n)) (base 10)
            We divided the input by 10 for every iteration,
            so the time complexity is O(log(n)) (base 10).
        Space complexity: O(1)
     */
    public static boolean isPalindrome(int x) {
        /*  Special cases
            1. Any negative number is not a palindrome
            2. Any integer that ends with 0 is not a palindrome, except 0 itself
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;

        /*  1.  To avoid the overflow problem for integers,
                we only reverse the last half the input number, and
                compare it with the first half
            2.  Keep dividing the input number by 10, and
                when the input number is smaller than (or equal to) the
                reverse number, we know half of the digits are processed.
                So, we can stop looping and compare the numbers
         */
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        /*  When the length of the input number is an odd number,
            the reverse number will include the middle digit at the end.
            So, we need to remove it;
         */
        return x == reverse || x == reverse / 10;
    }
}
