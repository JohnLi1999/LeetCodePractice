package medium._0547_Friend_Circles;

public class Solution_DFS {
    int[] visited;

    /*  https://leetcode.com/problems/friend-circles/
        Time complexity: O(n^2)
            The complete matrix of size n^2 is traversed.
        Space complexity: O(n)
            The visited array of size n is used.
     */
    public int findCircleNum(int[][] M) {
        visited = new int[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(M, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, j);
            }
        }
    }
}
