package easy._0058_Length_of_Last_Word;

public class Solution {
    /*  https://leetcode.com/problems/length-of-last-word/
        Time Complexity: O(n)
            N is the length of the input string.
            In the worst case, the input string might contain only a single word,
            which implies that we would need to iterate through the entire string to obtain the result.
        Space Complexity: O(1)
            Only constant memory is consumed, regardless the input.
     */
    public static int lengthOfLastWord(String s) {
        int count = 0;

        // Iterate the string from the end to the beginning
        for (int i = s.length() - 1; i >= 0; i--) {
            // Increase the counter by 1 when meeting a letter
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                // When meeting an empty space, return the count if it is not 0
                if (count != 0) {
                    break;
                }
            }
        }

        /*  The count will be 0 if there is no word, and
            it will be the length of the string if there is only one word
         */
        return count;
    }
}
