package medium._0583_Delete_Operation_for_Two_Strings.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("sea", "eat")); // 2
        System.out.println(s.minDistance("leetcode", "etco")); // 4
    }

    /*  Time complexity: O(m * n)
            m -> length of word1
            n -> length of word2
        Space complexity: O(m * n)
     */
    public int minDistance(String word1, String word2) {
        /*  If any of the two strings is empty
                -> distance is the length of the non-empty string

            If char a == char b
                -> minDistance(word1.substring(1), word2.substring(1))
            else
                -> 1 + min(
                        minDistance(word1.substring(1), word2),
                        minDistance(word1, word2.substring(1))
                   )
         */

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
