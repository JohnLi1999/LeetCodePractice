package hard._0072_Edit_Distance;

public class Solution_Brute_Force {
    /*  https://leetcode.com/problems/edit-distance/
        Time Complexity: O(2^{max(M,N)})
            Where M, N are the lengths of word1 and word2 respectively
        Space Complexity: O(max{M, N})
            The maximum recursive call can M or N
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() + word2.length();
        }

        if (word1.charAt(0) == word2.charAt(0)) {
            return minDistance(word1.substring(1), word2.substring(1));
        }

        int insert = 1 + minDistance(word1, word2.substring(1));
        int delete = 1 + minDistance(word1.substring(1), word2);
        int replace = 1 + minDistance(word1.substring(1), word2.substring(1));

        return Math.min(insert, Math.min(delete, replace));
    }
}
