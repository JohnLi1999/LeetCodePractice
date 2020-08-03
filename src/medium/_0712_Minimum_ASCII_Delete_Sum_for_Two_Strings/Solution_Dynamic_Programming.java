package medium._0712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

public class Solution_Dynamic_Programming {
    /*  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
        Time Complexity: O(M * N)
            Where M, N are the lengths of the given strings.
            We use nested for loops: each loop is O(M) and O(N) respectively.
        Space Complexity: O(M * N)
            The space used by dp array.
     */
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = sum(1, j, s2);
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = sum(1, i, s1);
                    continue;
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min((int) s1.charAt(i - 1) + dp[i - 1][j],
                                        (int) s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private int sum(int start, int end, String word) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += word.charAt(i - 1);
        }
        return sum;
    }
}
