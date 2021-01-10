package hard._0407_Trapping_Rain_Water_II;

import java.util.Comparator;
import java.util.PriorityQueue;

/*  https://leetcode.com/problems/trapping-rain-water-ii/
    Time complexity: O(m * n * log(m + n))
        Where m and n are the width and length of the given heights array
        As the priority queue we created takes O(m + n) element on average, the insertion
        operation of the priority queue takes O(log(m + n)) time. Since we need to add every
        height into the priority queue exactly once, the overall time complexity is
        O(m * n * log(m + n))
    Space complexity: O(m + n)
        On average, the priority queue contains only border elements.
        So the space it takes is 2 * (m + n). Thus the space complexity is O(m + n)
 */
public class Solution_Sample {
    public int trapRainWater(int[][] heightMap) {
        // Sanity Check
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });
        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            queue.add(new Cell(0, j, heightMap[0][j]));
            queue.add(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        /*  From the borders, pick the shortest cell visited and check
            its neighbours. If the neighbour is shorter, collect the water
            it can trap and update its height as its height plus the water trapped.
            Add all its neighbour to the queue.
         */
        int[][] dirs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int total = 0;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] dir : dirs) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];

                if (row >= 0 && row < m &&
                    col >= 0 && col < n &&
                    !visited[row][col]) {
                    visited[row][col] = true;
                    total += Math.max(0, cell.height - heightMap[row][col]);
                    queue.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }

        return total;
    }

    private static class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}

