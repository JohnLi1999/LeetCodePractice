package hard._0336_Palindrome_Pairs.notes;

import java.util.*;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time Complexity: O(k^2 * n)
            Let n be the number of words, and k be the length of the longest word.
            Building the hash table takes O(n * k) time. Each word takes O(k) time to insert and there are n words.
            Then, for each of the n words we are searching for 3 different cases.
        First is the word's own reverse. This takes O(k) time. Second is words
        that are a palindrome followed by the reverse of another word. Third is words
        that are the reverse of another word followed by a palindrome. These second 2 cases have the same cost,
        so we'll just focus on the first one. We need to find all the prefixes of the given word, that are palindromes.
        Finding all palindrome prefixes of a word can be done in O(k^2) time, as there are k possible prefixes,
        and checking each one takes O(k) time. So, for each word we are doing k^2 + k^2 + k processing,
        which in big-oh notation is O(k^2). Because are doing this with n words,
        we get a final result of O(k^2 * n).
            It's worth noting that the previous approach had a cost of O(n^2 * k).
        Therefore, this approach isn't better in every case. It is only better where n > k.
        In the test cases your solution is tested on, this is indeed the case.
    Space Complexity: O((k + n)^2)
            Like before, there are several components we need to consider. This time however,
        the space complexity is the same regardless of whether or not we include the input in the calculations.
        This is because the algorithm immediately creates a hash table the same size as the input.
            In the input, there are n words, with a length of up to k each. This gives us O(n * k).
        We are then building a hash table with n keys of size k. The hash table is the same size as the original input,
        so it too is O(n * k).
            For each word, we're making a list of all possible pair words that need to be looked up in the hash table.
        In the worst case, there'll be k words to look up, with lengths of up to k.
        This means that at each cycle of the loop, we're using up to k^2 memory for the lookup list.
        This could be optimized down to O(k) by only creating one of the words at a time.
        In practice though, it's unlikely to make much difference due to the way strings are handled under the hood.
        So, we'll say that we're using an additional O(k^2) memory.
            Determining the size of the output is the same as the other approaches. In the worst case,
        there'll be n * (n - 1) pairs of integers in the output list, as each of the n words
        could pair with any of the other n - 1 words. Each pair will add 2 integers to the input list,
        giving a total of 2 * n * (n - 1) = 2 * n^2 - 2 * n. Dropping the constant and insignificant terms,
        we are left with an output size of O(n^2).
            Putting this all together, we get 2 * n * k + k ^ 2 + n ^ 2 = (k + n)^2, which is O((k + n)^2).
 */
public class Hashing {
    private List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, i, word.length() - 1)) {
                validPrefixes.add(word.substring(0, i));
            }
        }
        return validPrefixes;
    }

    private List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, 0, i)) {
                validSuffixes.add(word.substring(i + 1, word.length()));
            }
        }
        return validSuffixes;
    }

    // Is the prefix ending at i a palindrome?
    private boolean isPalindromeBetween(String word, int front, int back) {
        while (front < back) {
            if (word.charAt(front) != word.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        // Build a word -> original index mapping for efficient lookup.
        Map<String, Integer> wordSet = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }

        // Make a list to put all the palindrome pairs we find in.
        List<List<Integer>> solution = new ArrayList<>();

        for (String word : wordSet.keySet()) {

            int currentWordIndex = wordSet.get(word);
            String reversedWord = new StringBuilder(word).reverse().toString();

            // Build solutions of case #1. This word will be word 1.
            if (wordSet.containsKey(reversedWord)
                    && wordSet.get(reversedWord) != currentWordIndex) {
                solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedWord)));
            }

            // Build solutions of case #2. This word will be word 2.
            for (String suffix : allValidSuffixes(word)) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (wordSet.containsKey(reversedSuffix)) {
                    solution.add(Arrays.asList(wordSet.get(reversedSuffix), currentWordIndex));
                }
            }

            // Build solutions of case #3. This word will be word 1.
            for (String prefix : allValidPrefixes(word)) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (wordSet.containsKey(reversedPrefix)) {
                    solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedPrefix)));
                }
            }
        }

        return solution;
    }
}