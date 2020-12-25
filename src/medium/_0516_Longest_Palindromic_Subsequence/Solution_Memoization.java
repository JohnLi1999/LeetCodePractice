package medium._0516_Longest_Palindromic_Subsequence;

/*  https://leetcode.com/problems/longest-palindromic-subsequence/
    Time complexity: O(n^2)
    Space complexity: O(n^2)
        We use a 2D cache array
 */
public class Solution_Memoization {
    int[][] cache;

    public int longestPalindromeSubseq(String s) {
        StringBuilder r = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            r.append(s.charAt(i));
        }

        String reverse = r.toString();
        cache = new int[s.length()][reverse.length()];

        return memoization(s, reverse);
    }

    public int memoization(String s1, String s2) {
        if (s1.equals(s2)) {
            return s1.length();
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if (cache[s1.length() - 1][s2.length() - 1] != 0) {
            return cache[s1.length() - 1][s2.length() - 1];
        }

        int result;
        char c1 = s1.charAt(0);
        int index = s2.indexOf(c1);

        if (index == -1) {
            result = memoization(s1.substring(1), s2);
        } else {
            result = Math.max(1 + memoization(s1.substring(1), s2.substring(index + 1)), memoization(s1.substring(1), s2));
        }

        cache[s1.length() - 1][s2.length() - 1] = result;

        return result;
    }
}
