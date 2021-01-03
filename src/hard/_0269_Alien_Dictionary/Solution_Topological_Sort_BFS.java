package hard._0269_Alien_Dictionary;

import java.util.*;

/*  https://leetcode.com/problems/alien-dictionary/
    To see more detailed explanation, check 0269. Alien Dictionary.png

    Time complexity: O(C)
        Where C is the total length of all the words in the input list, added together.
    Space complexity: O(1) or O(U + min(U^2, N))
        Where N is the total number of strings in the input list
        , and U is the total number of unique letters in the alien alphabet.
        While this is limited to 26 in the question description,
        we'll still look at how it would impact the complexity if it was not limited
        (as this could potentially be a follow-up question).
 */
public class Solution_Topological_Sort_BFS {

    /* adjList saves all unique characters and all its adjacent characters  */
    private final Map<Character, List<Character>> adjList = new HashMap<>();
    /* indegrees saves all unique characters and its indegree count */
    private final Map<Character, Integer> indegrees = new HashMap<>();
    /* queue is used to help the topological sort */
    private final Deque<Character> queue = new LinkedList<>();

    public String alienOrder(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }

        /* Find all unique words */
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
                indegrees.putIfAbsent(c, 0);
            }
        }

        /* Find all rules between letters */
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            /* Prefix should appear before all words with it  */
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {
                    adjList.get(c1).add(c2);
                    indegrees.put(c2, indegrees.get(c2) + 1);
                    break;
                }
            }
        }

        /* Topological sort using BFS */
        StringBuilder sb = new StringBuilder();

        /* Step 1: add the characters with indegree 0 into the queue*/
        for (Character c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                queue.add(c);
            }
        }

        /* Step 2: traverse the queue until it is empty */
        while (!queue.isEmpty()) {
            /* Step 2.1: poll out one character from queue and append it to end of the final result */
            Character c = queue.poll();
            sb.append(c);

            /*  Step 2.2:
                        When add a char into the final result, it means we remove it from the graph,
                    (which is represented as the adjList in the implementation).
                    Now, since it is removed, so the indegree of all of its adjacent characters
                    should decrease by 1.
                        We also need to check the updated indegree. If it is zero, then we also add
                    that character into the queue.
             */
            for (Character adjChar : adjList.get(c)) {
                indegrees.put(adjChar, indegrees.get(adjChar) - 1);
                if (indegrees.get(adjChar) == 0) {
                    queue.add(adjChar);
                }
            }
        }

        /*  The final answer should contain all unique characters form the input.
            If we found the number of length of the final result is smaller that the count
            of all unique characters, it means there is a loop in the graph we formed.
            So this infers we meet an invalid input, and we need to return an empty string
         */
        if (sb.length() < indegrees.size()) {
            return "";
        }

        return sb.toString();
    }
}
