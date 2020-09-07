package medium._0785_Is_Graph_Bipartite;

import java.util.*;

/*  https://leetcode.com/problems/is-graph-bipartite/
    Time Complexity: O(N + E)
        Where N is the number of nodes in the graph, and E is the number of edges.
        We explore each node once when we transform it from uncolored to colored,
        traversing all its edges in the process.
    Space Complexity: O(N)
        The space used to store the nodes.
 */
public class Solution_Super_Slow {
    private int[][] graph;
    private boolean[] visited;
    private List<List<Integer>> sets;
    private boolean[] result;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        visited = new boolean[graph.length];
        sets = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        result = new boolean[] { true };

        int maxSoFar = -1;
        do {
            sets.get(0).add(maxSoFar + 1);
            visited[maxSoFar + 1] = true;
            traverse(maxSoFar + 1, 1);

            maxSoFar = Math.max(
                    sets.get(0).stream().max(Comparator.comparingInt(x -> x)).isPresent()
                            ? sets.get(0).stream().max(Comparator.comparingInt(x -> x)).get()
                            : 0,
                    sets.get(1).stream().max(Comparator.comparingInt(x -> x)).isPresent()
                            ? sets.get(1).stream().max(Comparator.comparingInt(x -> x)).get()
                            : 0);
        } while (graph.length - 1 > maxSoFar);

        return result[0];
    }

    private void traverse(int currentNode, int setToInsert) {
        if (!result[0]) {
            return;
        }

        if (graph[currentNode].length == 0 && currentNode != graph.length - 1) {
            traverse(currentNode + 1, (setToInsert + 1) % 2);
        }

        for (int i = 0; i < graph[currentNode].length; i++) {
            int node = graph[currentNode][i];

            if (visited[node]) {
                if (sets.get((setToInsert + 1) % 2).contains(node)) {
                    result[0] = false;
                    break;
                }
            } else {
                sets.get(setToInsert).add(node);
                visited[node] = true;
                traverse(node, (setToInsert + 1) % 2);
            }
        }
    }
}
