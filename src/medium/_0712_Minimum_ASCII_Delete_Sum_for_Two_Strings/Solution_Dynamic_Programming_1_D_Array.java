package medium._0712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

public class Solution_Dynamic_Programming_1_D_Array {
    /*  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
        Time Complexity: O(M * N)
            Where M, N are the lengths of the given strings.
            We use nested for loops: each loop is O(M) and O(N) respectively.
        Space Complexity: O(N)
            Where N is the length of the second string
            The space used by dp array.
     */
    public int minimumDeleteSum(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];

        for (int i = 1; i <= s2.length(); i++) {
            dp[i] = dp[i - 1] + s2.codePointAt(i - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {

            // Two variable to save previous and current result
            int prev = dp[0], curr;
            // dp[0] is the place to save cumulative sums in s1
            dp[0] = dp[0] + s1.codePointAt(i - 1);

            for (int j = 1; j <= s2.length(); j++) {
                curr = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(s1.codePointAt(i - 1) + dp[j],  // Delete character in s1
                                     s2.codePointAt(j - 1) + dp[j - 1]);  // Delete character in s2
                }

                prev = curr;
            }
        }

        return dp[s2.length()];
    }
}
