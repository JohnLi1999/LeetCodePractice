package medium._0583_Delete_Operation_for_Two_Strings;

public class Solution_Brute_Force {
    public int minDistance(String word1, String word2) {
        /*  When one of the strings is consumed,
            we need to delete all characters in the other string, when the remaining length of that string.
            Return the sum of the two strings since one of them is 0
         */
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() + word2.length();
        }

        // Choose the first character in the first word
        int letter = word1.charAt(0);
        // Search the character in the second word
        int index = word2.indexOf(letter);

        // Case 1: Delete the first character in the first word and keep searching
        int case1 = 1 + minDistance(word1.substring(1), word2);
        // Initialize case2 as the result int case1
        int case2 = case1;

        // If the second word contains the first character in the first word
        if (index != -1) {
            /*  Case 2: Keep that character in the first word, and
                delete all other characters before the that character in the second word  */
            case2 = index + minDistance(word1.substring(1), word2.substring(index + 1));
        }

        // Return the minimum value between case 1 and case 2
        return Math.min(case1, case2);
    }
}
