package hard._0072_Edit_Distance;

public class Solution_Dynamic_Programming_1_D_Array {
    /*  https://leetcode.com/problems/edit-distance/
        Time complexity: O(M⋅N)
            We're solving M⋅N sub-problems. Solving each sub-problem is an O(1) operation.
        Space complexity: O(N)
            We'e allocating an 1-D array of size N
     */
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];

        for (int i = 0; i <= word2.length(); i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {

            int prev = dp[0];
            dp[0] = i;

            for (int j = 1; j <= word2.length(); j++) {
                int curr = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                }

                prev = curr;
            }
        }

        return dp[word2.length()];
    }
}
