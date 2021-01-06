package medium._0583_Delete_Operation_for_Two_Strings.notes;

/*  Time complexity: O(m*n)
        We need to fill in the dp array of size m*n.
        Here, m and n refer to the lengths of s1 and s2.
    Space complexity: O(m*n)
        DP_Bottom_Up array of size m*n is used.
 */
public class Using_Longest_Common_Subsequence_Dynamic_Programming {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }
}
