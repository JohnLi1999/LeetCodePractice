package hard._0336_Palindrome_Pairs;

import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time complexity: O(m * n^2)
        Where m is the average length of very word and n is the number of strings in words array
        We use a nested loop to get all possible pairs of distinct words and check
        if the combination to them is a palindrome
    Space complexity: O(n^2)
        In the worst case, all possible pairs of distinct words are palindromes.
        So we need O(n^2) space to store the results list
 */
/** This method fails because it exceeds the time limit **/
public class Solution_My_Way {
    private String[] words;
    private List<List<Integer>> results;

    public List<List<Integer>> palindromePairs(String[] words) {
        this.words = words;
        this.results = new LinkedList<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                checkStrings(i, j);
            }
        }

        return results;
    }

    private void checkStrings(int i, int j) {
        String s1 = words[i], s2 = words[j];
        int m = s1.length(), n = s2.length();

        if (m == n) {
            for (int k = 0; k < m; k++) {
                if (s1.charAt(k) != s2.charAt(m - k - 1)) {
                    return;
                }
            }

            results.add(List.of(i, j));
            results.add(List.of(j, i));
            return;
        }

        if (hasPalindrome(s1 + s2)) {
            results.add(List.of(i, j));
        }

        if (hasPalindrome(s2 + s1)) {
            results.add(List.of(j, i));
        }
    }

    private boolean hasPalindrome(String word) {
        int n = word.length();

        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
