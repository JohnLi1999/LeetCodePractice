package hard._0044_Wildcard_Matching;

/*  https://leetcode.com/problems/wildcard-matching/
    Time complexity: O(SP)
        Where S and P are lengths of the input string and the pattern correspondingly.
    Space complexity: O(SP)
        To keep the dp matrix.
 */
public class Solution_DP_My_Way {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (i == s.length()) {
                    dp[i][j] = p.charAt(j) == '*' && dp[i][j + 1];
                } else {
                    if (p.charAt(j) == '*') {
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else {
                        dp[i][j] = (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                                && dp[i + 1][j + 1];
                    }
                }
            }
        }

        return dp[0][0];
    }
}
