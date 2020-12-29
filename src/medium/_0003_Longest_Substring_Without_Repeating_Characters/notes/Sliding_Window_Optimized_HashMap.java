package medium._0003_Longest_Substring_Without_Repeating_Characters.notes;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time complexity: O(n)
        Index j will iterate n times.
    Space complexity (HashMap): O(min(m, n))
        Same as the previous approach.
 */
public class Sliding_Window_Optimized_HashMap {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
