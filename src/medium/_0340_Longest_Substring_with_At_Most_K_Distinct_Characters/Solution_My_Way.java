package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity: O(n * k)
        Where n is the number of characters in string s, and k is the number of distinct characters
        We traverse each character exactly once. When we need to remove an element from map, we want
        to find the element that has smallest value, so it takes O(k) time. Thus, in the worst case,
        we need to traverse the map for each element in the for loop, which takes O(n * k) time
    Space complexity: O(k)
        We need a map to store the k distinct characters
 */
public class Solution_My_Way {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) || map.keySet().size() < k) {
                map.put(c, i);
                len++;
                continue;
            }

            /* Case for map does not contains c and there are k distinct elements in map */

            // Update max length
            max = Math.max(max, len);

            /*  Find the element that has the least value.
                This mean its last appearing is in the least position
             */
            int lastIndex = Integer.MAX_VALUE;
            char charToRemove = '#';
            for (char ch : map.keySet()) {
                if (map.get(ch) < lastIndex) {
                    lastIndex = map.get(ch);
                    charToRemove = ch;
                }
            }
            map.remove(charToRemove);

            // Update start index and length of current window
            len = i - lastIndex;

            // Put the new element in the window
            map.put(c, i);
        }

        max = Math.max(max, len);

        return max;
    }
}
