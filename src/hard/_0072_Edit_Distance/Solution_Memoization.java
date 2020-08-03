package hard._0072_Edit_Distance;

public class Solution_Memoization {
    String word1;
    String word2;
    int len1;
    int len2;
    int[][] dp;

    /*  https://leetcode.com/problems/edit-distance/
        Time complexity: O(M⋅N)
            There are M possible positions for the first string, and N for the second string.
            Therefore, this gives us M⋅N possible pairs of integers,
            and is the number of sub-problems to be solved.
            Solving each sub-problem has a cost of O(1), so we get a total time complexity of O(M⋅N).
        Space complexity: O(M⋅N).
            We need to store the answer for each of the M⋅N sub-problems.
            Each sub-problem takes O(1) space to store. This gives us a total of O(M⋅N).
     */
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        len1 = word1.length();
        len2 = word2.length();
        dp = new int[len1 + 1][len2 + 1];

        // Fill dp array with -1
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = -1;
            }
        }

        /*  Base case for the recursion:
            When we reach the end of one of the strings,
            we will return the remaining length of the other strings */
        for (int i = 0; i < len1; i++) {
            dp[i][len2] = len1 - i;
        }
        for (int j = 0; j < len2; j++) {
            dp[len1][j] = len2 - j;
        }

        return helper(0, 0);
    }

    private int helper(int i, int j) {
        // When we meet a save result or a base case, we directly return the result in dp array
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Case 1: word1[i] equals word2[j]
        if (word1.charAt(i) == word2.charAt(j)) {
            // We do not need to do any action and keep searching the remaining of word1 and word2
            dp[i][j] = helper(i + 1, j + 1);
        } else {
            /*  Case 2: word[i] not equals word2[j],
                and we need to perform one of the three operations  */

            /*  If we insert word2[j] into word1,
                we will keep searching all word1 and the remaining of word2  */
            int insert = 1 + helper(i, j + 1);
            /*  If we delete word1[i] from word1,
                we will keep searching the remaining of word1 and all word2  */
            int delete = 1 + helper(i + 1, j);
            /*  If we replace word1[i] with word2[j] in word1,
                we will keep searching the remaining of word1 and the remaining of word2  */
            int replace = 1 + helper(i + 1, j + 1);

            /*  Find the minimum value from insertion, deletion, and replacement operations,
                save the result into dp array  */
            dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        // return the value in dp array
        return dp[i][j];
    }
}
