package hard._0072_Edit_Distance.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("horse", "ros")); // 3
        System.out.println(s.minDistance("intention", "execution")); // 5
    }

    /*  Time complexity: O(m * n)
            m -> length of word1
            n -> length of word2
        Space complexity: O(m * n)
     */
    public int minDistance(String word1, String word2) {
        /*  If any of the two strings is empty
                -> distance = length of the non-empty string

            If char a == char b
                -> distance = minDistance(word1.substring(1), word2.substring(1))
            else
                -> distance = 1 + min(
                        word1.substring(1), word2.substring(1), // replace
                        word1.substring(1), word2, // delete
                        word1, word2.substring(1) // insert
                   )

            Explanations:
                1.  The case that one of the string is the empty,
                    we delete just delete the other string.
                2.  Examples
                        word1 = "horse", word2 = "ros"
                        word1 = "intention", word2 = "execution"

                    Replace: e.g. horse -> rorse (replace 'h' with 'r')
                        both strings move forward one character
                    Delete: e.g. rorse -> rose (remove 'r')
                        rorse is moving forward from r -> s
                        ros does not change
                    Insert: e.g. exection -> execution (insert 'u')
                        exection is adding 'u', so basically does not change
                        execution is moving forward from u -> t
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
                    dp[i][j] = 1 + Math.min(
                                dp[i - 1][j - 1], // replace
                            Math.min(
                                dp[i - 1][j], // delete
                                dp[i][j - 1] // insert
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }
}
