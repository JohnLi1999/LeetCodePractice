package medium._0003_Longest_Substring_Without_Repeating_Characters.notes;

import java.util.HashSet;
import java.util.Set;

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time complexity: O(n^3)
        To verify if characters within index range [i, j) are all unique, we need to scan all of them.
        Thus, it costs O(j - i) time. For a given i, the sum of time costed by each j ∈ [i + 1, n] is
        ∑{n, i+1} O(j - i). Thus, the sum of all the time consumption is:
        O( ∑{n-1, i=0} ( ∑{n, j=i+1} (j - 1) ) ) = O( ∑{n-1, i=0} (1+n-i(n-1)/2 ) = O(n^3)
    Space complexity: O(min(n, m))
        We need O(k) space for checking a substring has no duplicate characters,
        where k is the size of the Set. The size of the Set is upper bounded by
        the size of the string n and the size of the charset/alphabet m.
 */
public class Brute_Force {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}