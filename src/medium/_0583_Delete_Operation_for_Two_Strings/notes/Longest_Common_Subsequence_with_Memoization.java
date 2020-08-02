package medium._0583_Delete_Operation_for_Two_Strings.notes;

/*  Time complexity : O(m*n)
        Memo array of size m*n needs to be filled once.
        Here, m and n refer to the length of the strings s1 and s2 respectively.
    Space complexity : O(m*n)
        Memo array of size m*n is used.
        Also, The depth of the recursion tree will go upto max(m,n).
 */
public class Longest_Common_Subsequence_with_Memoization {
    public int minDistance(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }

    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }

}

