package medium._1143_Longest_Common_Subsequence;

public class Solution_Dynamic_Programming {
    /*  https://leetcode.com/problems/longest-common-subsequence/
        Time complexity: O(M⋅N)
            Like before, we're solving M⋅N sub-problems, and each is an O(1) operation to solve.
        Space complexity: O(min(M,N))
            We've reduced the auxiliary space required so that
            we only use one 1D arrays and two variables at a time,
            leaving us with the minimum length out of the two words.
 */
    public int longestCommonSubsequence_Bottom_Up_1D_Array(String text1, String text2) {
        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] dp = new int[text1.length() + 1];

        for (int i = text2.length() - 1; i >= 0; i--) {
            // Declare two variables to save for previous results
            int prev = 0, curr;
            for (int j = text1.length() - 1; j >= 0; j--) {
                curr = dp[j];

                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }

                prev = curr;
            }
        }

        return dp[0];
    }

    /*  https://leetcode.com/problems/longest-common-subsequence/
        Time complexity: O(M⋅N)
            We're solving M⋅N sub-problems. Solving each sub-problem is an O(1) operation.
        Space complexity: O(M⋅N)
            We're allocating a 2D array of size M⋅N to save the answers to sub-problems.
     */
    public int longestCommonSubsequence_Bottom_Up_2D_Array(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
