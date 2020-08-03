package medium._0712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

/*  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
    Time Complexity: O(M * N^2)
        Where M, N are the lengths of the given strings.
        There are M possible positions for the first string, and N for the second string.
        Therefore, this gives us M * N possible pairs of integers, and is the number of sub-problems to be solved.
        Solving each sub-problem requires, in the worst case, an O(N) operation,
        searching for a character in a string of length N. This gives us a total of (M * N^2)
    Space Complexity: O(M * N)
        We need to store the answer for each of the M * N sub-problems.
        Each sub-problem takes O(1) space to store. This gives us a total of O(M⋅N).
 */
public class Solution_Memoization {
    String s1;
    String s2;
    int len1;
    int len2;
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        len1 = s1.length();
        len2 = s2.length();
        dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            dp[i][len2] = sum(i, len1 - 1, s1);
        }

        for (int j = 0; j < s2.length(); j++) {
            dp[len1][j] = sum(j, len2 - 1, s2);
        }

        return helper(0, 0);
    }

    private int helper(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int case1 = (int) s1.charAt(i) + helper(i + 1, j);

        int letter = s1.charAt(i);
        int index = s2.indexOf(letter, j);

        int case2 = case1;
        if (index != -1) {
            case2 = sum(j, index - 1, s2) + helper(i + 1, index + 1);
        }

        dp[i][j] = Math.min(case1, case2);
        return dp[i][j];
    }

    private int sum(int start, int end, String word) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += word.charAt(i);
        }
        return sum;
    }
}
