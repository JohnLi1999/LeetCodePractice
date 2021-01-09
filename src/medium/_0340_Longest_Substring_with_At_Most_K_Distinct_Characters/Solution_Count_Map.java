package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity: O(n)
        In the worst case, we traverse every element exactly twice.
        So the time complexity is O(n)
    Space complexity: O(k)
        The map can hold up to k elements
 */
public class Solution_Count_Map {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }

        /* Instead of indices, we store the frequency of the character we have seen */
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char ch = s.charAt(start);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                start++;
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
