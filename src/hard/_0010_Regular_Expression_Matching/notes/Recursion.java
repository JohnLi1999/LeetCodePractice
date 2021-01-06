package hard._0010_Regular_Expression_Matching.notes;

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
public class Recursion {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
