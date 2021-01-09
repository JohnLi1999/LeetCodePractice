package medium._0340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;

/*  https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity: O(n)
        In the worst case, we traverse every element exactly twice.
        So the time complexity is O(n)
    Space complexity: O(1)
        The character array has fixed length as we made the assumption
 */
/** This method makes an assumption of the input array that
    it will only up 256 different characters  **/
public class Solution_Count_Array {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();

        if (n * k == 0) {
            return 0;
        }

        /*  Instead of indices, we store the frequency of the character we have seen
            Also, we assume there are only 256 different characters in the given string  */
        int[] frequency = new int[256];
        int max = 0, start = 0, count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            frequency[c]++;
            if (frequency[c] == 1) {
                count++;
            }
            while (count > k) {
                char ch = s.charAt(start++);
                frequency[ch]--;
                if (frequency[ch] == 0) {
                    count--;
                }
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
