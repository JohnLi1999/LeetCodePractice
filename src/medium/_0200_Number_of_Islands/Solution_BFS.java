package medium._0200_Number_of_Islands;

import utils.pair_node.Pos;

import java.util.Deque;
import java.util.LinkedList;

/*  https://leetcode.com/problems/number-of-islands/
    Time complexity: O(M * N)
        Where M is the number of rows and N is the number of columns.
    Space complexity: O(min(M,N))
        Because in worst case where the grid is filled with lands, and
        the size of queue can grow up to min(M,N).
 */
public class Solution_BFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int width = grid.length;
        int height = grid[0].length;
        int islands = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    islands++;

                    Deque<Pos> queue = new LinkedList<>();
                    grid[i][j] = '0';
                    queue.add(new Pos(i, j));

                    while (!queue.isEmpty()) {
                        Pos pos = queue.poll();
                        int x = pos.x;
                        int y = pos.y;

                        // Top
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new Pos(x - 1, y));
                        }

                        // Bottom
                        if (x + 1 < width && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new Pos(x + 1, y));
                        }

                        // Left
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new Pos(x, y - 1));
                        }

                        // Right
                        if (y + 1 < height && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new Pos(x, y + 1));
                        }
                    }
                }
            }
        }

        return islands;
    }
}