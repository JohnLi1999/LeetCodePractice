package easy._0028_Implement_strStr_method.notes;

/*  https://leetcode.com/problems/implement-strstr/
    Time complexity:
        O((N−L)*L) in the worst case of numerous almost complete false matches, and
        O(N) in the best case of one single match.
    Space complexity: O(1)
 */
public class Two_Pointers_Linear_Time_Slice {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
}
