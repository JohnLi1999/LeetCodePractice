package medium._1143_Longest_Common_Subsequence;

public class Solution_Brute_Force {
    /*  Time Complexity: O(2^N)
            Where N is the length of the shorter text
        Space Complexity: O(N*M)
            Where N and M are the lengths of the two pieces of text
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }

    private int helper(char[] text1, char[] text2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (text1[i - 1] == text2[j - 1]) {
            return 1 + helper(text1, text2, i - 1, j - 1);
        } else {
            return Math.max(helper(text1, text2, i - 1, j), helper(text1, text2, i, j - 1));
        }
    }
}
