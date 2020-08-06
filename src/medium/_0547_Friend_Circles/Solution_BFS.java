package medium._0547_Friend_Circles;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_BFS {
    /*  https://leetcode.com/problems/friend-circles/
        Time complexity: O(n^2)
            The complete matrix of size n^2 is traversed.
        Space complexity: O(n)
            A queue and a visited array of size n is used.
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;

                queue.add(i);
                while (!queue.isEmpty()) {
                    int n = queue.poll();

                    for (int j = 0; j < M.length; j++) {
                        if (M[n][j] == 1 && visited[j] == 0) {
                            visited[j] = 1;

                            queue.add(j);
                        }
                    }
                }

                count++;
            }
        }

        return count;
    }
}
