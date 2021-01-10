package medium._0417_Pacific_Atlantic_Water_Flow;

import java.util.*;

/*  https://leetcode.com/problems/pacific-atlantic-water-flow/
    Time complexity: O((m * n)^2)
        Where m and n are the width and length of the given matrix
        We traverse all the points given in the matrix, and for each point, we do a breath-first-search
        in the whole matrix. So in the worst case, it takes (m * n) * (m * n) time.
        Thus, the time complexity is O((m * n)^2)
    Space complexity: O(m * n)
        The results list, visited array, and queue used in bfs all takes O(m * n) space
 */
public class Solution_My_Way {
    private int[][] matrix;
    private int m;
    private int n;
    private final int[][] directions = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    private final Set<List<Integer>> results = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;

        results.add(List.of(m - 1, 0));
        results.add(List.of(0, n - 1));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == m - 1 && j == 0) || (i == 0 && j == n - 1)) {
                    continue;
                }
                if (bfs(i, j)) {
                    results.add(List.of(i, j));
                }
            }
        }

        return new ArrayList<>(results);
    }

    private boolean bfs(int x, int y) {
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, matrix[x][y]});
        boolean pacific = false, atlantic = false;

        if (x == 0 || y == 0) {
            pacific = true;
        }
        if (x == m - 1 || y == n - 1) {
            atlantic = true;
        }
        if (pacific && atlantic || results.contains(List.of(x, y))	) {
            return true;
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int currX = pos[0];
            int currY = pos[1];
            int currH = pos[2];

            for (int[] direction : directions) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];

                if (nextX >= 0 && nextX < m &&
                    nextY >= 0 && nextY < n &&
                    !visited[nextX][nextY]		) {
                    int nextH = matrix[nextX][nextY];

                    if (currH >= nextH) {

                        if (nextX == 0 || nextY == 0) {
                            pacific = true;
                        }
                        if (nextX == m - 1 || nextY == n - 1) {
                            atlantic = true;
                        }
                        if (pacific && atlantic ||  results.contains(List.of(nextX, nextY))	) {
                            return true;
                        }

                        visited[nextX][nextY] = true;
                        queue.add(new int[] {nextX, nextY, nextH});
                    }
                }
            }
        }

        return false;
    }
}

