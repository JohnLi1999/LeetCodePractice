package medium._0583_Delete_Operation_for_Two_Strings;

/*  https://leetcode.com/problems/delete-operation-for-two-strings/
    Time complexity : O(m*n)
        Memo array of size m*n needs to be filled once.
        Here, m and n refer to the length of the strings s1 and s2 respectively.
    Space complexity : O(m*n)
        Memo array of size m*n is used.
        Also, The depth of the recursion tree will go upto max(m,n).
 */
public class Solution_Dynamic_Programming {
    String word1;
    String word2;
    int len1;
    int len2;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        len1 = word1.length();
        len2 = word2.length();
        dp = new int[len1 + 1][len2 + 1];

        // Initialize the dp array with -1
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = -1;
            }
        }

        // For all the corner cases, we set the value as the remain length of the two strings
        for (int i = 0; i < len1; i++) {
            dp[i][len2] = len1 - i;
        }
        for (int j = 0; j < len2; j++) {
            dp[len1][j] = len2 - j;
        }

        return helper(0, 0);
    }

    private int helper(int i, int j) {
        // If there is a value in dp[i][j], directly return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        /*  Case 1: Delete the first character (increase delete operation by 1) in the word1 and
            do not make change in word2. Keep searching the rest of word1 and the word2 */
        int case1 = 1 + helper(i + 1, j);

        // Choose the character at position i in the word1
        int letter = word1.charAt(i);
        // Search that character in the word2, starting from position j in word2
        int index = word2.indexOf(letter, j);

        // Initialize case2 as the result int case1
        int case2 = case1;
        if (index != -1) {
            /*  Case 2: If word2 has that character, we keep the character in word1 and
                delete all other characters before the that character in the word2
                (increase delete operation by index)
                Keep searching the rest of word1 and the rest of word2 */
            case2 = index - j + helper(i + 1, index + 1);
        }

        // Save the minimum value between case1 and case2 into dp[i][j], and return it
        dp[i][j] = Math.min(case1, case2);
        return dp[i][j];
    }
}
