package medium._0583_Delete_Operation_for_Two_Strings.notes;

/*  Time complexity: O(m*n)
        We need to fill in the dp array of size m*n.
        Here, m and n refer to the lengths of s1 and s2.
    Space complexity: O(m*n)
        DP_Bottom_Up array of size m*n is used.
 */
public class Without_Using_LCS_Dynamic_Programming {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
