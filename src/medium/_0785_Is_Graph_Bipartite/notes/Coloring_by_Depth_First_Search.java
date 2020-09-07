package medium._0785_Is_Graph_Bipartite.notes;

import java.util.Arrays;
import java.util.Stack;

/*  Time Complexity: O(N + E)
        Where N is the number of nodes in the graph, and E is the number of edges.
        We explore each node once when we transform it from uncolored to colored,
        traversing all its edges in the process.
    Space Complexity: O(N)
        The space used to store the color.
 */
public class Coloring_by_Depth_First_Search {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}