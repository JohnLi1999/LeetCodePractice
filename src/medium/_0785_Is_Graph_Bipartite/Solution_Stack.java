package medium._0785_Is_Graph_Bipartite;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*  https://leetcode.com/problems/is-graph-bipartite/
    Time Complexity: O(N + E)
        Where N is the number of nodes in the graph, and E is the number of edges.
        We explore each node once when we transform it from uncolored to colored,
        traversing all its edges in the process.
    Space Complexity: O(N)
        The space used to store the color.
 */
public class Solution_Stack {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;

                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    int[] neighbours = graph[node];

                    for (int neighbour : neighbours) {
                        if (colors[neighbour] == -1) {
                            stack.push(neighbour);
                            colors[neighbour] = colors[node] ^ 1;
                        } else if (colors[neighbour] == colors[node]) {
                            System.out.println(neighbour);
                            System.out.println(node);
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
