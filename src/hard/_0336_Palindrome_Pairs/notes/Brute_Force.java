package hard._0336_Palindrome_Pairs.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  https://leetcode.com/problems/palindrome-pairs/
    Time Complexity: O(n^2 * k)
            Let n be the number of words, and k be the length of the longest word.
            There are n^2 pairs of words. Then appending 2 words requires time 2k,
        as does reversing it and then comparing it for equality.
        The constants are dropped, leaving kk. So in total, we get O(n^2 * k).
        We can't do better than this with the brute-force approach.
    Auxiliary Space Complexity: O(n^2 + k)
            Auxiliary space is where we do not consider the size of the input.
            Let's start by working out the size of the output. In the worst case,
        there'll be n*(n−1) pairs of integers in the output list,
        as each of the n words could pair with any of the other n - 1n−1 words.
        Each pair will add 2 integers to the input list, giving a total of
        2 * n * (n−1) = 2 * n^2 - 2 * n. Dropping the constant and insignificant terms,
        we are left with an output size of O(n^2).
            Now, how much space do we use to find all the pairs? Each time around the loop,
        we are combining 2 words and creating an additional (reversed) copy of the combined words.
        This is 4*k, which gives us O(k). We don't need to multiply this by n^2 because we aren't
        keeping the combined/ reversed words.
            In total, this gives us O(n^2 + k). It might initially seem like the k should be dropped,
        as it's less significant than the n^2. This isn't always the case though.
        If the words were really long, and the list very short, then it's possible for kk to be bigger than n^2.
            It's possible to optimize this slightly to O(n^2). By using an in-place algorithm to
        determine whether or not 2 given words form a palindrome, the k would become a 1 and therefore be dropped.
        Like said above though, it'd be wasted effort to do so. Especially given that in practice
        it's likely that k is smaller than n^2 anyway.
    Space Complexity: O(n*k + n^2)
        For this, we also need to take into account the size of the input.
        There are n words, with a length of up to k each. This gives us O(n*k).
        Like above, we can't assume anything about whether k > n or k < n.
        Therefore, we don't know whether O(n^2 + k) or O(n*k) is bigger.
 */
public class Brute_Force {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String combined = words[i].concat(words[j]);
                String reversed = new StringBuilder(combined).reverse().toString();
                if (combined.equals(reversed)) {
                    pairs.add(Arrays.asList(i, j));
                }
            }
        }

        return pairs;
    }
}
