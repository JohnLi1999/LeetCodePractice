package medium._0547_Friend_Circles.notes;

import java.util.LinkedList;
import java.util.Queue;

/*  Time complexity: O(n^2)
        The complete matrix of size n^2 is traversed.
    Space complexity: O(n)
        A queue and a visited array of size n is used.
 */
public class BFS {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue< Integer > queue = new LinkedList< >();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}