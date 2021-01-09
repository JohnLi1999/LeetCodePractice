package hard._0336_Palindrome_Pairs;

import java.util.*;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time Complexity: O(k^2 * n)
    Space Complexity: O((k + n)^2)
 */
public class Solution_HashMap {
    public List<List<Integer>> palindromePairs(String[] words) {
        /*  Crux: there are only three cases for the combined palindrome
            Assume string 1 is s1 with length m, adn string 2 is s2 with length n
                Case 1: m == n
                    [  s1  ][  s2  ] and s2 is the reverse of s2
                Case 2: m < n
                    [     s1     ][ palindrome ][ s1_reverse ]
                                  [            s2            ]
                    the suffix of s2 is the reverse of s1, and the remaining part of s2 is also a palindrome
                Case 3: m > n
                    [ s2_reverse ][ palindrome ][     s2     ]
                    [            s1            ]
                    the prefix of s1 is the reverse of s2, and the remaining part of s1 is also a palindrome

            Based on the crux, the key job for us is to find the proper prefixes and suffixes
         */

        List<List<Integer>> pairs = new ArrayList<>();

        /* Create the hashtable to save all strings and their indices */
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        /* Traverse all strings and find palindrome pairs based on the three cases in crux */
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverse = new StringBuilder(word).reverse().toString();

            /*  Case 1:
                The current word represents s1, and we want to find its reverse, which represents s2.
                Be aware of that we cannot add the same index twice in the same pair!  */
            if (map.containsKey(reverse) && map.get(reverse) != i) {
                pairs.add(List.of(i, map.get(reverse)));
            }

            /*  Case 2:
                The current word represents s2, and we want to find all
                its valid suffixes (palindrome + suffix).
                The suffix is the reverse of s1  */
            for (String suffix : findAllValidSuffixes(word)) {
                String s1 = new StringBuilder(suffix).reverse().toString();
                if (map.containsKey(s1)) {
                    /* Be careful with the sequence in case 2, index of s1 should appear at first */
                    pairs.add(List.of(map.get(s1), i));
                }
            }


            /*  Case 3:
                The current word represents s1, and we want to find all
                its valid prefixes (prefix + palindrome).
                The prefix is the reverse of s2  */
            for (String prefix : findAllValidPrefixes(word)) {
                String s2 = new StringBuilder(prefix).reverse().toString();
                if (map.containsKey(s2)) {
                    pairs.add(List.of(i, map.get(s2)));
                }
            }
        }

        return pairs;
    }

    private List<String> findAllValidSuffixes(String word) {
        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                suffixes.add(word.substring(i + 1));
            }
        }

        return suffixes;
    }

    private List<String> findAllValidPrefixes(String word) {
        List<String> prefixes = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                prefixes.add(word.substring(0, i));
            }
        }

        return prefixes;
    }

    private boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
