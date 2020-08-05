package medium._0200_Number_of_Islands;

public class Solution_DFS {
    private int width;
    private int height;
    private char[][] grid;

    /*  https://leetcode.com/problems/number-of-islands/
        Time complexity: O(M * N)
            Where M is the number of rows and N is the number of columns.
        Space complexity: O(M * N) for the worst case
            In case that the grid map is filled with lands where DFS goes by M * N deep.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.grid = grid;
        this.width = grid.length;
        this.height = grid[0].length;

        int islands = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    islands++;

                    grid[i][j] = '0';

                    dfs(i, j);
                }
            }
        }

        return islands;
    }

    private void dfs(int x, int y) {
        // Top
        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
            grid[x - 1][y] = '0';
            dfs(x - 1, y);
        }

        // Bottom
        if (x + 1 < width && grid[x + 1][y] == '1') {
            grid[x + 1][y] = '0';
            dfs(x + 1, y);
        }

        // Left
        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
            grid[x][y - 1] = '0';
            dfs(x, y - 1);
        }

        // Right
        if (y + 1 < height && grid[x][y + 1] == '1') {
            grid[x][y + 1] = '0';
            dfs(x, y + 1);
        }
    }
}
