package easy._0028_Implement_strStr_method;

/*  https://leetcode.com/problems/implement-strstr/
    Time complexity: O(M + N)
        Let M be the length of haystack and N be the length of needle.
        We need O(N) time to find the LPS array of needle,
        and O(M) time to traverse haystack.
    Space complexity: O(N)
        We need O(N) space to store LPS array of needle
 */
public class Solution_KMP {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0;
        }

        int[] lps = getLPS(needle);
        int i = 0, j = 0;

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                // Found needle in haystack
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    private int[] getLPS(String str) {
        int n= str.length();

        /* LPS: Longest Prefix and Suffix */
        int[] lps = new int[n];
        int len = 0, i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }

        return lps;
    }
}


