package hard._0269_Alien_Dictionary.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*  https://leetcode.com/problems/alien-dictionary/
    To see more detailed explanation, check 0269. Alien Dictionary.png

    Time complexity: O(C)
        Building the adjacency list has a time complexity of O(C) for the same reason as in Approach 1.
        Again, like in Approach 1, we traverse every "edge", but this time we're using depth-first-search.
    Space complexity: O(1) or O(U + min(U^2, N))
        Like in Approach 1, we build an adjacency list.
        Even though this one is a reversed adjacency list, it still contains the same number of relations.
 */
public class Depth_First_Search {
    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private Map<Character, Boolean> seen = new HashMap<>();
    private StringBuilder output = new StringBuilder();

    public String alienOrder(String[] words) {

        // Step 0: Put all unique letters into reverseAdjList as keys.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // Step 2: DFS to build up the output list.
        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }


        if (output.length() < reverseAdjList.size()) {
            return "";
        }
        return output.toString();
    }

    // Return true iff no cycles detected.
    private boolean dfs(Character c) {
        if (seen.containsKey(c)) {
            return seen.get(c); // If this node was grey (false), a cycle was detected.
        }
        seen.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false;
        }
        seen.put(c, true);
        output.append(c);
        return true;
    }
}