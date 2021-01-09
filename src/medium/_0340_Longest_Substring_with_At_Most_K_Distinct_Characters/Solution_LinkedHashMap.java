package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.LinkedHashMap;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity: O(n)
    Space complexity: O(k)
 */
public class Solution_LinkedHashMap {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();

        if (n * k == 0) {
            return 0;
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int max = Integer.MIN_VALUE;
        int len = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) || map.size() < k) {
                if (map.containsKey(c)) {
                    map.remove(c);
                }
                map.put(c, i);
                len++;
                continue;
            }

            max = Math.max(max, len);

            /* Due to the property of LinkedHashMap, we know the lastChar has the lowest value */
            char lastChar = map.keySet().iterator().next();
            len = i - map.get(lastChar);
            map.remove(lastChar);
            map.put(c, i);
        }

        max = Math.max(max, len);

        return max;
    }
}
