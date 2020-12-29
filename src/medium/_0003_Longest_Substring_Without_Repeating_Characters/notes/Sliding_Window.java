package medium._0003_Longest_Substring_Without_Repeating_Characters.notes;

import java.util.HashSet;
import java.util.Set;

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time complexity: O(2n) = O(n)
        In the worst case each character will be visited twice by ii and jj.
    Space complexity: O(min(m, n))
        Same as the previous approach. We need O(k) space for the sliding window,
        where k is the size of the Set. The size of the Set is upper bounded by
        the size of the string n and the size of the charset/alphabet m.
 */
public class Sliding_Window {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}