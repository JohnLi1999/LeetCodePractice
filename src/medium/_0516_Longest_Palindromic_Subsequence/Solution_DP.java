package medium._0516_Longest_Palindromic_Subsequence;

/*  https://leetcode.com/problems/longest-palindromic-subsequence/
    Time complexity: O(n^2)
        We use two nested loops to traverse the string the the reversed string
    Space complexity: O(n^2)
        We use a 2D dp array
 */
public class Solution_DP {
    public int longestPalindromeSubseq(String s) {
        return using_pure_palindrome(s);
//        return using_longestCommonSubsequence(s);
    }

    public int using_pure_palindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];

        /*  Logic
                Traverse all different segments (length of 2 to n) in the string,
                and compare the characters at the start and the end of the segments.
                And store the compare results into a 2D dp array.

                For example:
                    segment: ... [i i+1 ... j-1 j] ...
                    if s(i) == s(j)
                        dp[i][j] = 2 + dp[i + 1][j - 1]
                    if s(i) != s(j)
                        dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
         */

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (c[i] == c[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    /*  We first reverse the given string and find the longest common subsequence between
        the two strings. The length of the longest common subsequence will the the length
        of the longest palindrome subsequence.
     */
    public int using_longestCommonSubsequence(String s) {
        // Reverse the string for palindrome
        StringBuilder str = new StringBuilder(s);
        char[] s1 = str.toString().toCharArray();
        char[] s2 = str.reverse().toString().toCharArray(); // reversed s

        // Declare the dp array
        int[][] dp = new int[s1.length + 1][s2.length + 1];

        /*  Logic
                State Transition Function:
                if s1(n) == s2(m)
                    f(n, m) = 1 + f(n - 1, m - 1)
                if s1(n) != s2(m)
                    f(n, m) = max(f(n - 1, m), f(n, m - 1))
            DP_Bottom_Up array:
                ...  0   ... m-1 m   ... ]
                0   [0   ... ... ... 0   ]
                ... [0   ... ... ... ... ]
                n-1 [0   ... x1  x3  ... ]
                n   [0   ... x2  x4  ... ]
                ... [0   ... ... ... ... ]
            Suppose we are given x1, x2, x3, and we need to calculate x4, which is f(n, m).
            We have two cases:
                1. The n-th character in s1 is the same as the m-th character in s2. [s1(n) == s2(m)]
                    In this case, we can simply add 1 to its sub-optimized result f(n-1, m-1), which is x1.
                    In this case, we don't need care about x2 and x3 since they are not sub-optimized results
                    for f(n, m).
                2. The n-th character in s1 is different from the m-th character in s2. [s1(n) != s2(m)]
                    In this case, we ignore either s1(n) or s2(m) because they are different.
                    So, we need to use previous result, which are x2 [f(n, m-1)] and x3 [f(n-1, m)].
                    We compare their value and choose the larger one.
         */
        for (int i = 0; i < s1.length + 1; i++) {
            for (int j = 0; j < s2.length + 1; j++) {
                if (i == 0 || j == 0) {
                    // We initialize dp[0][m] and dp[n][0] to 0 for boundary values
                    dp[i][j] = 0;
                }
                else if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }
}
