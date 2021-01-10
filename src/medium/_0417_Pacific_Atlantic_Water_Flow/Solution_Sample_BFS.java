package medium._0417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/pacific-atlantic-water-flow/
    Time complexity: O(m * n)
        Where m and n are the width and length of the given matrix.
        We search reachable positions for the Pacific and Atlantic separately, and
        each breath-first-search takes (m * n) time. In the end, it also takes O(m * n) time
        to merge the results. So, in total, it takes (3 * m * n) time.
        So, the time complexity is O(m * n)
    Space complexity: O(m * n)
        The directions array takes O(1) space.
        The queue used for BFS takes up to O(m * n) space.
        The visited array takes O(m * n) space.
        So, the space complexity is O(m * n)
 */
public class Solution_Sample_BFS {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> results = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacificReachable = bfs(matrix, true);
        boolean[][] atlanticReachable = bfs(matrix, false);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    results.add(List.of(i, j));
                }
            }
        }

        return results;
    }

    private boolean[][] bfs(int[][] matrix, boolean isPacific) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; /* top, bottom, left, right */
        Deque<int[]> queue = new LinkedList<>();

        /*  Add edges (positions on the edges can always flow to the ocean)
            For Pacific, the edges are the first row and first column
            For Atlantic, the edges are the last row and last column
         */
        for (int row = 0; row < m; row++) {
            int col = isPacific ? 0 : n - 1;
            visited[row][col] = true;
            queue.add(new int[] { row, col, matrix[row][col]});
        }
        for (int col = 0; col < n; col++) {
            int row = isPacific ? 0 : m - 1;
            visited[row][col] = true;
            queue.add(new int[] { row, col, matrix[row][col]});
        }

        /*  Use BFS to traverse the matrix, and find out
            all the positions that is reachable to the Pacific or the Atlantic.
            If the position is reachable, we mark it as true in the visited matrix.
            Otherwise, we do not.
         */
        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int currRow = currPos[0];
            int currCol = currPos[1];
            int currHeight = currPos[2];

            /* Traverse in all directions */
            for (int[] direction : directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];

                /* If the next position if valid */
                if (nextRow >= 0 && nextRow < m &&
                    nextCol >= 0 && nextCol < n &&
                    !visited[nextRow][nextCol]) {
                    /*  Add the position in to the queue if
                        the height of the next position is higher than or equal to
                        the height of the current position.
                        This means the water can flow from next position to current position.
                        As our current position is reachable to the ocean, it means
                        the next position is also reachable to the ocean  */
                    int nextHeight = matrix[nextRow][nextCol];
                    if (nextHeight >= currHeight) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[] {nextRow, nextCol, nextHeight});
                    }
                }
            }
        }

        return visited;
    }
}
