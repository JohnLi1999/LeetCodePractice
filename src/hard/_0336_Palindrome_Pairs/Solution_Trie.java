package hard._0336_Palindrome_Pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time Complexity: O(k^2 * n)
    Space Complexity: O((k + n)^2)
 */
public class Solution_Trie {
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
         */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        /* Build Trie */
        TrieNode root = new TrieNode();

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            TrieNode currentRoot = root;

            /*  We save the reverse of the current into the Trie so that we can search the word itself
                when searching its palindrome pair in the next step */
            for (int charIndex = word.length() - 1; charIndex >= 0; charIndex--) {
                /*  Add the wordIndex into palindrome in the TrieNode
                    if the remaining part of current is a palindrome  */
                if (hasPalindrome(word, 0, charIndex)) {
                    currentRoot.palindromes.add(wordIndex);
                }

                /* Add current character into the Trie */
                char c = word.charAt(charIndex);
                if (!currentRoot.children.containsKey(c)) {
                    currentRoot.children.put(c, new TrieNode());
                }
                currentRoot = currentRoot.children.get(c);
            }

            /*  After we traverse the word, set its ending index as
                the index of the current word in words array */
            currentRoot.index = wordIndex;
        }

        /* Search Trie for palindrome pairs */
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            TrieNode currentRoot = root;

            for (int charIndex = 0; charIndex < word.length(); charIndex++) {
                /*  Case 3
                    The current word is s1
                    The currentRoot.index presents s2  */
                if (currentRoot.index != -1 && hasPalindrome(word, charIndex, word.length() - 1)) {
                    pairs.add(List.of(wordIndex, currentRoot.index));
                }

                char c = word.charAt(charIndex);
                currentRoot = currentRoot.children.get(c);
                if (currentRoot == null) {
                    break;
                }
            }

            /*  If current root is null, it means there is no more character
                matching the remaining part of current word  */
            if (currentRoot == null) {
                continue;
            }

            /*  Case 1
                We found the reverse of current  */
            if (currentRoot.index != -1 && currentRoot.index != wordIndex) {
                pairs.add(List.of(wordIndex, currentRoot.index));
            }

            /*  Case 2
                The current word is s1
                The palindromeIndices represents all s2 words  */
            for (int palindromeIndex : currentRoot.palindromes) {
                pairs.add(List.of(wordIndex, palindromeIndex));
            }
        }

        return pairs;
    }

    private boolean hasPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    /* Index in the words array, used as ending purpose */
    public int index = -1;
    /* List to save indices of strings that have a palindrome in the remaining */
    public List<Integer> palindromes = new ArrayList<>();
    /* Children TrieNode for the next layer */
    public Map<Character, TrieNode> children = new HashMap<>();
}
