package medium._0785_Is_Graph_Bipartite;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*  https://leetcode.com/problems/is-graph-bipartite/
    Time Complexity: O(N + E)
        Where N is the number of nodes in the graph, and E is the number of edges.
        We explore each node once when we transform it from uncolored to colored,
        traversing all its edges in the process.
    Space Complexity: O(N)
        The space used to store the color.
 */
public class Solution_Queue {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;

                Deque<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    int[] neighbours = graph[node];

                    for (int neighbour : neighbours) {
                        if (colors[neighbour] == -1) {
                            queue.add(neighbour);
                            colors[neighbour] = colors[node] ^ 1; // 1 ^ 1 = 0; 0 ^ 1 = 1
                        } else if (colors[neighbour] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
