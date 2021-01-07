package easy._0028_Implement_strStr_method;

/*  https://leetcode.com/problems/implement-strstr/
    Time complexity:
        O((N−L)*L) in the worst case
        O(N) in the average and best case
            Where N is a length of haystack and L is a length of needle.
            O((N−L)*L) in the worst case of numerous almost complete false matches, and
            O(N) in the best case of one single match.
    Space complexity: O(N + L)
        We convert both strings into char arrays and use (N + L) space
 */
public class Solution_My_Way {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for (int i = 0; i < h.length - n.length + 1; i++) {
            if (h[i] == n[0]) {
                boolean match = true;
                for (int j = 1; j < n.length; j++) {
                    if (h[i + j] != n[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }

        return -1;
    }
}
