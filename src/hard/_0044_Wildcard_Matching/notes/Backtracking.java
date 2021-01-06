package hard._0044_Wildcard_Matching.notes;

/*  https://leetcode.com/problems/wildcard-matching/
    Time complexity:
        O(min(S,P)) for the best case
        O(S*log(P)) for the average case
        Where S and P are lengths of the input string and the pattern correspondingly.
        Please refer to this article for the detailed proof.
        https://arxiv.org/pdf/1407.0950.pdf
    Space complexity: O(1)
        Since it's a constant space solution.
 */
public class Backtracking {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // If the pattern character = string character
            // or pattern character = '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                ++sIdx;
                ++pIdx;
            }
            // If pattern character = '*'
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern
            else if (starIdx == -1) {
                return false;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for(int i = pIdx; i < pLen; i++)
            if (p.charAt(i) != '*') return false;
        return true;
    }
}
