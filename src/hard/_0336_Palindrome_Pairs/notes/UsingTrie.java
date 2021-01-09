package hard._0336_Palindrome_Pairs.notes;

import java.util.*;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time Complexity : O(k^2 * n)
            Let n be the number of words, and k be the length of the longest word.
            There were 2 major steps to the algorithm. Firstly, we needed to build the Trie.
        Secondly, we needed to look up each word in the Trie.
            Inserting each word into the Trie takes O(k) time. As well as inserting the word,
        we also checked at each letter whether or not the remaining part of the word was a palindrome.
        These checks had a cost of O(k), and with k of them, gave a total cost of O(k^2).
        With nn words to insert, the total cost of building the Trie was therefore O(k^2 * n).
            Checking for each word in the Trie had a similar cost. Each time we encountered a node with
        a word ending index, we needed to check whether or not the current word we were looking up
        had a palindrome remaining. In the worst case, we'd have to do this k times at a cost of k for each time.
        So like before, there is a cost of k^2 for looking up a word,
        and an overall cost of k^2 * n for all the checks.
            This is the same as for the hash table approach.
    Space Complexity : O((k + n)^2)
            The Trie is the main space usage. In the worst case, each of the O(n * k) letters
        in the input would be on separate nodes, and each node would have up to n indexes in its list.
        This gives us a worst case of O(n^2 * k), which is strictly larger than the input or the output.
            Inserting and looking up words only takes k space though, because we're not generating
        a list of prefixes like we were in approach 2. This is insignificant compared to the size of the Trie itself.
            So in total, the size of the Trie has a worst case of O(k * n^2). In practice however,
        it'll use a lot less, as we based this on the worst case. Tries are difficult to analyze in the general case,
        because their performance is so dependent on the type of data going into them. As n gets
        really, really, big, the Trie approach will eventually beat the hash table approach on both time and space.
        For the values of n that we're dealing with in this question though, you'll probably notice that
        the hash table approach performs better.
 */
public class UsingTrie {
    // Is the given string a palindrome after index i?
    // Tip: Leave this as a method stub in an interview unless you have time
    // or the interviewer tells you to write it. The Trie itself should be
    // the main focus of your time.
    public boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) return false;
            p1++; p2--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        TrieNode trie = new TrieNode();

        // Build the Trie
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            String reversedWord = new StringBuilder(word).reverse().toString();
            TrieNode currentTrieLevel = trie;
            for (int j = 0; j < word.length(); j++) {
                if (hasPalindromeRemaining(reversedWord, j)) {
                    currentTrieLevel.palindromePrefixRemaining.add(wordId);
                }
                Character c = reversedWord.charAt(j);
                if (!currentTrieLevel.next.containsKey(c)) {
                    currentTrieLevel.next.put(c, new TrieNode());
                }
                currentTrieLevel = currentTrieLevel.next.get(c);
            }
            currentTrieLevel.wordEnding = wordId;
        }

        // Find pairs
        List<List<Integer>> pairs = new ArrayList<>();
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            TrieNode currentTrieLevel = trie;
            for (int j = 0; j < word.length(); j++) {
                // Check for pairs of case 3.
                if (currentTrieLevel.wordEnding != -1
                        && hasPalindromeRemaining(word, j)) {
                    pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
                }
                // Move down to the next trie level.
                Character c = word.charAt(j);
                currentTrieLevel = currentTrieLevel.next.get(c);
                if (currentTrieLevel == null) break;
            }
            if (currentTrieLevel == null) continue;
            // Check for pairs of case 1. Note the check to prevent non distinct pairs.
            if (currentTrieLevel.wordEnding != -1 && currentTrieLevel.wordEnding != wordId) {
                pairs.add(Arrays.asList(wordId, currentTrieLevel.wordEnding));
            }
            // Check for pairs of case 2.
            for (int other : currentTrieLevel.palindromePrefixRemaining) {
                pairs.add(Arrays.asList(wordId, other));
            }
        }

        return pairs;
    }
}

class TrieNode {
    public int wordEnding = -1; // We'll use -1 to mean there's no word ending here.
    public Map<Character, TrieNode> next = new HashMap<>();
    public List<Integer> palindromePrefixRemaining = new ArrayList<>();
}
