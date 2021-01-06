package medium._0583_Delete_Operation_for_Two_Strings;

public class Solution_LCS_Dynamic_Programming {
    /*  https://leetcode.com/problems/delete-operation-for-two-strings/
        Time complexity : O(m*n)
            We need to fill in the dp array of size O(m), n times.
            Here, n and m refer to the lengths of s1 and s2.
        Space complexity : O(m).
            DP_Bottom_Up array of size O(m) is used.
     */
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];

        for (int i = word1.length() - 1; i >= 0; i--) {
            int prev = 0, curr;
            for (int j = word2.length() - 1; j >= 0; j--) {
                curr = dp[j];

                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }

                prev = curr;
            }
        }

        return word1.length() + word2.length() - 2 * dp[0];
    }
}
