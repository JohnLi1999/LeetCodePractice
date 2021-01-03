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
public class Solution_Topological_Sort_DFS {

    /* adjList saves all unique characters and all its adjacent characters  */
    private final Map<Character, List<Character>> adjList = new HashMap<>();
    /* stack, visited, and loop are used to help the topological sort */
    private final Deque<Character> stack = new ArrayDeque<>();
    private final Set<Character> visited = new HashSet<>();
    private final Set<Character> loop = new HashSet<>();

    public String alienOrder(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }

        /* Find all unique words */
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
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
                    break;
                }
            }
        }

        /* Topological sort using BFS */
        for (Character c : adjList.keySet()) {
            if (!visited.contains(c)) {
                /*  The starting point of DFS
                    Also, if there is a loop in the graph (indicate it is an invalid input),
                    we directly return an empty string
                 */
                if (!topologicalSort_DFS(c)) {
                    return "";
                }
            }
        }

        /* Final result can be obtained by the traverse of stack reversely */
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private boolean topologicalSort_DFS(Character c) {
        /* Mark current character as visited and check for loop  */
        visited.add(c);
        loop.add(c);

        /* Traverse all adjacent characters of the current char */
        for (Character adjChar : adjList.get(c)) {
            if (loop.contains(adjChar)) {
                /* If there is a loop in the graph, the input in invalid. And we return false */
                return false;
            }

            /* If the character has not been visited, we check it recursively */
            if (!visited.contains(adjChar)) {
                if (!topologicalSort_DFS(adjChar)) {
                    return false;
                }
            }
        }

        /*  When get here, it means the search of current character is done.
            So, remove the character from the loop set and add it into the stack */
        loop.remove(c);
        stack.push(c);

        /* If there is no loop, we return true */
        return true;
    }
}