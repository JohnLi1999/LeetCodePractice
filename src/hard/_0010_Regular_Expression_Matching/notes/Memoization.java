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

enum Result {
    TRUE, FALSE
}

public class Memoization {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
