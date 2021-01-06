package hard._0010_Regular_Expression_Matching.notes;

/*  https://leetcode.com/problems/regular-expression-matching/
    Time Complexity: O(TP)
        Let T, P be the lengths of the text and the pattern respectively.
        The work for every call to dp(i, j) for i = 0, ... , T ; j = 0, ... , P  is done once, and
        it is O(1) work. Hence, the time complexity is O(TP)
    Space Complexity: O(TP)
        The only memory we use is the O(TP) boolean entries in our cache.
        Hence, the space complexity is O(TP)
 */
public class DP_Bottom_Up {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}