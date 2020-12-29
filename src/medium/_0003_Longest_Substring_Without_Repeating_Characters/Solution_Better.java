package medium._0003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time complexity: O(n)
        Index j will iterate n times.
    Space complexity (HashMap): O(min(m, n))
        We need O(k) space for the sliding window,
        where k is the size of the Set. The size of the Set is upper bounded by
        the size of the string n and the size of the charset/alphabet m.
 */
public class Solution_Better {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        // Use a hash map to record the visited characters and their positions
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        /*  i points to the starting position of the substring without repeating characters
            j is used to traverse the string and points to end of
            the substring without repeating characters  */
        for (int i = 0, j = 0; j < chars.length; j++) {
            /*  If the map has contained the character,
                we need to update the starting position of the substring without repeating characters.
                Now the starting position is the next index of the previous position of this repeated character
                (map.get(chars[j]) + 1). However, if the current starting position is larger than that index.
                We keep the i unchanged (Math.max(i, map.get(chars[j]) + 1)); */
            if (map.containsKey(chars[j])) {
                i = Math.max(i, map.get(chars[j]) + 1);
            }

            /*  If the character is not repeated, then we just add it into the map
                If the character is repeated, here we update its position  */
            map.put(chars[j], j);

            /*  Update the max length,
                (j - i + 1) is the length of the current substring without repeating characters */
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
