package medium._0003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution_My_Way {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>();
        int max = 0;
        int len = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (set.isEmpty() || !set.contains(c)) {
                set.add(c);
                len++;
            } else {
                if (len > max) {
                    max = len;
                }

                set.clear();
                len = 0;

                int index = 0;
                int prev = s.indexOf(c);
                while (prev != i) {
                    index = prev;
                    prev = s.indexOf(c, index + 1);
                }
                i = index;
            }
        }

        return Math.max(max, len);
    }
}
