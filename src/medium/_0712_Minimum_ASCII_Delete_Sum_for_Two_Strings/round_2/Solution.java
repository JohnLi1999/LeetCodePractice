package medium._0712_Minimum_ASCII_Delete_Sum_for_Two_Strings.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumDeleteSum("sea", "eat")); // 231
        System.out.println(s.minimumDeleteSum("delete", "leet")); // 403
    }

    /*  Time complexity: O(m * n)
            m -> length of s1
            n -> length of s2
        Space complexity: O(m * n)
     */
    public int minimumDeleteSum(String s1, String s2) {
        /*  If any of the two strings is empty,
                -> sum = ASCII sum of all character of the non-empty string
            If char a == char b
                -> sum = minimumDeleteSum(s1.substring(1), s2.substring(1))
            else
                -> sum = min(
                        ASCII sum of char a + minimumDeleteSum(s1.substring(1), s2)
                        ASCII sum of char b + minimumDeleteSum(s1, s2.substring(1))
                   )
         */

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialization
        dp[0][0] = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s1.charAt(i);
            dp[i + 1][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s2.charAt(i);
            dp[0][i + 1] = sum;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            s1.charAt(i - 1) + dp[i - 1][j],
                            s2.charAt(j - 1) + dp[i][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }
}
