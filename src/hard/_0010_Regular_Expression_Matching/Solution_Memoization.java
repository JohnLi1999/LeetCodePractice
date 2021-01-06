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
public class Solution_Memoization {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        memo = new Boolean[s.length() + 1][p.length() + 1];
//        return isMatch_Front_To_End(s, 0, p,0);
        return isMatch_End_To_Front(s, s.length(), p,p.length());
    }

    /* In this way, we iterate all characters from the very front to the end */
    public boolean isMatch_Front_To_End(String s, int i, String p, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;

        if (j == p.length()) {
            result = i == s.length();
        } else {
            boolean firstMatch = i < s.length() &&
                    (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

            if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
                result = isMatch_Front_To_End(s, i, p, j + 2) ||
                        (firstMatch && isMatch_Front_To_End(s, i + 1, p, j));
            } else {
                result = firstMatch && isMatch_Front_To_End(s, i + 1, p, j + 1);
            }
        }

        memo[i][j] = result;
        return memo[i][j];
    }

    /* In this way, we iterate all characters from the very end to the front */
    public boolean isMatch_End_To_Front(String s, int i, String p, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result;

        /*  i and j points to the (index + 1) of the character we are checking
            So, if any of then reaches 0, it means we have done the checking that string */
        if (j == 0) {
            result = i == 0;
        } else if (i == 0) {
            result = p.charAt(j - 1) == '*' && isMatch_End_To_Front(s, i, p, j - 2);
        } else {
            if (p.charAt(j - 1) != '*') {
                /*  Case for p[j - 1] is not wildcard
                    The last characters should match  */
                result = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1))
                        && isMatch_End_To_Front(s, i - 1, p, j - 1);
            } else {
                /*  Case for p[j - 1] is wildcard
                        Sub-case 1: the wildcard can be empty string
                        Sub-case 2: the wildcard represents one or more characters, and
                                    the repeat characters in p should match the character in s
                    The last characters should match  */
                result =
                        // sub-case 1
                        isMatch_End_To_Front(s, i, p, j - 2) ||
                                // sub-case 2
                                (   (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))
                                        && isMatch_End_To_Front(s, i - 1, p, j)     );
            }
        }

        memo[i][j] = result;
        return memo[i][j];
    }
}
