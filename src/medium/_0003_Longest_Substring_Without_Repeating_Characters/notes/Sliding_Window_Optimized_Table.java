package medium._0003_Longest_Substring_Without_Repeating_Characters.notes;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time complexity: O(n)
        Index j will iterate n times.
    Space complexity (Table): O(m)
        m is the size of the charset.
 */
public class Sliding_Window_Optimized_Table {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
