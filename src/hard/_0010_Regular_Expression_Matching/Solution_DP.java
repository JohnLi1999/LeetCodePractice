package hard._0010_Regular_Expression_Matching;

/*  https://leetcode.com/problems/regular-expression-matching/
    Time Complexity: O(TP)
        Let T, P be the lengths of the text and the pattern respectively.
        The work for every call to dp(i, j) for i = 0, ... , T ; j = 0, ... , P  is done once, and
        it is O(1) work. Hence, the time complexity is O(TP)
    Space Complexity: O(TP)
        The only memory we use is the O(TP) boolean entries in our cache.
        Hence, the space complexity is O(TP)
 */
public class Solution_DP {
    public boolean isMatch(String s, String p) {
        return front_to_end(s, p);
//        return end_to_front(s, p);
    }

    /*  This approach actually uses the same strategy in the front-to-end method in memoization,
        although we traverse the strings from end to front  */
    public boolean front_to_end(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() &&
                        (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    /*  This approach actually uses the same strategy in the end-to-front method in memoization,
        although we traverse the strings from front to end  */
    public boolean end_to_front(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // If both strings are empty, we treat it as true;
        dp[0][0] = true;

        /*  We traversing strings from end to front, so we must handle
            the cases that string p only left wildcards before starting traversal */
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))
                            && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 2] ||
                            (   (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))
                                    && dp[i - 1][j]     );
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
