package easy._0242_Valid_Anagram;

public class Solution {
    /*  https://leetcode.com/problems/valid-anagram/
        Time complexity: O(n)
            Time complexity is O(n) because accessing the counter table is a constant time operation.
        Space complexity: O(1)
            Although we do use extra space, the space complexity is O(1)
            because the table's size stays constant no matter how large n is.
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int count : alphabet) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
