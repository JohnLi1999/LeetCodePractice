package medium._0003_Longest_Substring_Without_Repeating_Characters.round_2;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(s.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(s.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(s.lengthOfLongestSubstring("au")); // 2
        System.out.println(s.lengthOfLongestSubstring("")); // 0
        System.out.println(s.lengthOfLongestSubstring("abba")); // 2
    }

    /*  Optimized hash map - shorter version
        Time complexity: O(n)
            n -> string length
        Space complexity: O(min(m, n)
            m -> number of unique characters
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (int valid = 0, i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && map.get(c) >= valid) {
                valid = map.get(c) + 1;
            }

            map.put(c, i);
            maxLen = Math.max(maxLen, i - valid + 1);
        }

        return maxLen;
    }

//    /*  Using hash map - optimized using valid index
//        Time complexity: O(n)
//            n -> string length
//        Space complexity: O(min(m, n)
//            m -> number of unique characters
//     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//
//        char[] str = s.toCharArray();
//        int maxLen = 1;
//        int len = 0;
//        int valid = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < str.length; i++) {
//            char c = str[i];
//
//            if (!map.containsKey(c)) {
//                len++;
//            } else {
//                if (map.get(c) < valid) {
//                    map.put(c, i);
//                    len++;
//                } else {
//                    if (len > maxLen) {
//                        maxLen = len;
//                    }
//                    len = i - map.get(c);
//                    valid = map.get(c) + 1;
//                }
//            }
//
//            map.put(c, i);
//        }
//
//        if (len > maxLen) {
//            maxLen = len;
//        }
//
//        return maxLen;
//    }

//    /*  Using hash map
//        Time complexity: O(n), more specifically: O(2n)
//            n -> string length
//        Space complexity: O(min(m, n)
//            m -> number of unique characters
//     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//
//        char[] str = s.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put(str[0], 0);
//        int maxLen = 1;
//        int len = 1;
//        int i = 1;
//
//        while (i < str.length) {
//            char c = str[i];
//            if (!map.containsKey(c)) {
//                map.put(c, i);
//                len++;
//                i++;
//            } else {
//                i = map.get(c) + 1;
//                map.clear();
//                if (len > maxLen) {
//                    maxLen = len;
//                }
//                len = 0;
//            }
//        }
//
//        if (len > maxLen) {
//            maxLen = len;
//        }
//
//        return maxLen;
//    }
}
