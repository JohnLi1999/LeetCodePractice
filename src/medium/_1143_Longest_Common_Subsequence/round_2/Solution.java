package medium._1143_Longest_Common_Subsequence.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde", "ace")); //3
        System.out.println(s.longestCommonSubsequence("abc", "abc")); //3
        System.out.println(s.longestCommonSubsequence("abc", "def")); //0
    }

    /*  Time complexity: O(m * n)
            m -> length of word1
            n -> length of word2
        Space complexity: O(m * n)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        /*  if char a == char b
                -> 1 + lcs(text1.substring(1), lcs(text2.substring()))
            else
                -> max(lcs(text1.substring(1), text2),
                       lcs(text1, text2.substring(2)))
            if any of text1 or text2 is an empty string
                -> 0
         */

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
