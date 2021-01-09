package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters.notes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity:
        O(N) in the best case of k distinct characters in the string, and
        O(N * k) in the worst case of N distinct characters in the string.
    Space complexity: O(k)
        Since additional space is used only for a hashmap with at most k + 1 elements.
 */
public class Sliding_Window_and_Hashmap {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++);

            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}