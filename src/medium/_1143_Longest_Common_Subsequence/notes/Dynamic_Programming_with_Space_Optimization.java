package medium._1143_Longest_Common_Subsequence.notes;

/*  Time complexity: O(M⋅N)
        Let M be the length of the first word, and N be the length of the second word.
        Like before, we're solving M⋅N sub-problems, and each is an O(1) operation to solve.
    Space complexity: O(min(M,N))
        We've reduced the auxiliary space required so that we only use two 1D arrays at a time,
        each the length of the shortest input word.
        Seeing as the 2 is a constant, we drop it, leaving us with the minimum length out of the two words.
 */
public class Dynamic_Programming_with_Space_Optimization {
    public int longestCommonSubsequence(String text1, String text2) {
        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        // The previous and current column starts with all 0's and like
        // before is 1 more than the length of the first word.
        int[] previous = new int[text1.length() + 1];
        int[] current = new int[text1.length() + 1];

        // Iterate through each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one, and vice versa.
            int[] temp = previous;
            previous = current;
            current = temp;
        }

        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }
}