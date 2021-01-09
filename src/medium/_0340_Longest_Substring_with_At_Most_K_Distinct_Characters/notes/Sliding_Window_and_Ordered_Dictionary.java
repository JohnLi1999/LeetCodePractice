package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters.notes;

import java.util.LinkedHashMap;
import java.util.Map;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity: O(N)
        Since all operations with ordered dictionary / LinkedHashMap:
            insert/get/delete/popitem (put/containsKey/remove)
        are done in a constant time.
    Space complexity: O(k)
        Since additional space is used only for an ordered dictionary with at most k + 1 elements.
 */
public class Sliding_Window_and_Ordered_Dictionary {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new LinkedHashMap<>();

        int maxLength = 1;

        while (right < n) {
            Character character = s.charAt(right);
            if (rightmostPosition.containsKey(character)) {
                rightmostPosition.remove(character);
            }
            rightmostPosition.put(character, right++);

            if (rightmostPosition.size() == k + 1) {
                Map.Entry<Character, Integer> leftmost =
                        rightmostPosition.entrySet().iterator().next();
                rightmostPosition.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}