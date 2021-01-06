package hard._0044_Wildcard_Matching;

/*  https://leetcode.com/problems/wildcard-matching/
    Time complexity:
        O(min(S,P)) for the best case
        O(2^min(S,P/2)) for the worst case
        where S and P are lengths of the input string and the pattern correspondingly.
        The best case is quite obvious, let's estimate the worst case.
        The most time consuming is the situation where recursion forms the tree on
        the star character in the pattern. In this situation, 2 branches are executed:
        helper(s, p[1:]) and helper(s[1:], p). So the time complexity is O(2^min(S,P)).
    Space complexity: O(2^min(S,P))
        To keep the memoization array and the recursion stack.
 */
public class Solution_Memoization_My_Way {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;

        if (j == p.length()) {
            result = i == s.length();
        } else if (i == s.length()) {
            result = p.charAt(j) == '*' && isMatch(s, i, p, j + 1);
        } else {
            if (p.charAt(j) == '*') {
                result = isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j);
            } else {
                result = (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                        && isMatch(s, i + 1, p, j + 1);
            }
        }

        memo[i][j] = result;
        return memo[i][j];
    }
}
