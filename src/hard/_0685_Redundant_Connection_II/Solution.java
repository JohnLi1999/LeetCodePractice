package hard._0685_Redundant_Connection_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
        Ideas:
        1.  form a directed graph
        2.  check for two cases
            2.1.    one node has two parents
            2.2.    no root element
        3.  if we found the nodes related to either of the case,
            we experiment to delete that edge, and do a BFS/DFS.
            If all nodes have been included and we did not meet any node twice.
            That means we succeeded.
        4.  Otherwise, we try another one until we found the one match the requirement,
            and it occurs last in the input array
     */

    private Map<Integer, List<Integer>> undirectedGraph;
    private Map<Integer, List<Integer>> directedGraph;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        /*  Form the both graph
                - the directed graph uses descendant as key [descendant <- parent]
         */
        for (int[] edge : edges) {
            /*  edge[0]: parent
                edge[1]: descendant
             */
            if (directedGraph.containsKey(edge[1])) {
                directedGraph.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                directedGraph.put(edge[1], list);
            }

            if (undirectedGraph.containsKey(edge[0])) {
                undirectedGraph.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                directedGraph.put(edge[0], list);
            }

            if (undirectedGraph.containsKey(edge[1])) {
                undirectedGraph.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                directedGraph.put(edge[1], list);
            }
        }

        // Number of nodes
        int n = undirectedGraph.size();



//        // Case one: node has two parents
//        for (int key : graph.keySet()) {
//            List<Integer> parents = graph.get(key);
//            if (parents.size() > 1) {
//                return new int[] {parents.get(parents.size() - 1), key};
//            }
//        }

        // Case two: no root



        return null;
    }

    private boolean deleteAndTraverse() {
        return false;
    }
}

