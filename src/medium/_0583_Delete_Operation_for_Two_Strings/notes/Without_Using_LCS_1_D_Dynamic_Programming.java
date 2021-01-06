package medium._0583_Delete_Operation_for_Two_Strings.notes;

/*  Time complexity: O(m*n)
        We need to fill in the dp array of size n, m times.
        Here, m and n refer to the lengths of s1 and s2.
    Space complexity: O(n)
        DP_Bottom_Up array of size n is used.
 */
public class Without_Using_LCS_1_D_Dynamic_Programming {
    public int minDistance(String s1, String s2) {
        int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp = new int[s2.length() + 1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    temp[j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    temp[j] = dp[j - 1];
                else
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
            }
            dp = temp;
        }
        return dp[s2.length()];
    }
}
