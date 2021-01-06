package hard._0044_Wildcard_Matching;

/*  https://leetcode.com/problems/wildcard-matching/
    Time complexity: O(2^min(S,P/2))
        where S and P are lengths of the input string and the pattern correspondingly.
        The best case is quite obvious, let's estimate the worst case.
        The most time consuming is the situation where recursion forms the tree on
        the star character in the pattern. In this situation, 2 branches are executed:
        helper(s, p[1:]) and helper(s[1:], p). So the time complexity is O(2^min(S,P)).
    Space complexity: O(2^min(S,P))
        To keep the memoization array and the recursion stack.
 */
public class Solution_Recursion_My_Way {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (i == s.length()) {
            return p.charAt(j) == '*' && isMatch(s, i, p, j + 1);
        }

        if (p.charAt(j) == '*') {
            return isMatch(s, i, p, j + 1) || isMatch(s, i + 1, p, j);
        } else {
            return (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    && isMatch(s, i + 1, p, j + 1);
        }
    }
}
