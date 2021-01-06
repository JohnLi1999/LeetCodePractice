package hard._0010_Regular_Expression_Matching;

/*  https://leetcode.com/problems/regular-expression-matching/
    Time Complexity: O( (T+P) * 2^{T + P/2} )
        Let T, P be the lengths of the text and the pattern respectively.
        In the worst case, a call to match(text[i:], pattern[2j:]) will be made (i + j chooses i) times,
        and strings of the order O(T - i) and O(P - 2*j) will be made. Thus, the complexity has the order
        ∑(T, i=0) ( ∑(P/2, j=0) ( (i + j chooses i) * O(T + P - i - 2*j) ) )
        With some effort outside the scope of this article, we can show this is bounded by
        O( (T+P) * 2^{T + P/2} )
    Space Complexity: O( (T+P) * 2^{T + P/2} )
        For every call to match, we will create those strings as described above,
        possibly creating duplicates. If memory is not freed, this will also take a total of
        O( (T+P) * 2^{T + P/2} ) space, even though there are only order O(T^2 + P^2) unique suffixes
        of P and T that are actually required.
 */
public class Solution_Recursion {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatch_Sample_Solution(s, 0, p, 0);
//        return isMatch_My_Way(s, 0, p, 0);
    }

    public boolean isMatch_Sample_Solution(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        // Check if the first character matches
        boolean firstMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            // This is for the case that the wildcard (*) can represent an empty string
            return isMatch_Sample_Solution(s, i, p, j + 2) ||
                    // we can search the next character in string s only if first characters match
                    (firstMatch && isMatch_Sample_Solution(s, i + 1, p, j));
        } else {
            // If no wildcard (*), keep searching next characters only if first characters match
            return firstMatch && isMatch_Sample_Solution(s, i + 1, p, j + 1);
        }
    }

    public boolean isMatch_My_Way(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        boolean match = i < s.length() && s.charAt(i) == p.charAt(j);

        boolean nextIsStart = j <= p.length() - 2 && p.charAt(j + 1) == '*';

        if (match) {
            if (nextIsStart) {
                return isMatch_My_Way(s, i, p, j + 2) || isMatch_My_Way(s, i + 1, p, j);
            } else {
                return isMatch_My_Way(s, i + 1, p, j + 1);
            }
        } else {
            if (p.charAt(j) == '.') {
                if (nextIsStart) {
                    if (i > s.length()) {
                        return false;
                    }
                    return isMatch_My_Way(s, i, p, j + 2) || isMatch_My_Way(s, i + 1, p, j);
                } else {
                    return isMatch_My_Way(s, i + 1, p, j + 1);
                }
            } else {
                if (nextIsStart) {
                    return isMatch_My_Way(s, i, p, j + 2);
                } else {
                    return false;
                }
            }
        }
    }
}
