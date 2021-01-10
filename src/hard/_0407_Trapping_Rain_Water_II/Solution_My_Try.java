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
public class Solution_My_Try {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.height));
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] {
                {-1, 0}, // top
                {0, 1}, // right
                {1, 0}, // bottom
                {0, -1}  // left
        };
        int amount = 0;

        // Add borders
        for (int i = 0; i < m; i++) {
            if (i == 0 || i == m - 1) {
                for (int j = 0; j < n; j++) {
                    pq.add(new Cell(heightMap[i][j], i, j));
                    visited[i][j] = true;
                }
            } else {
                pq.add(new Cell(heightMap[i][0], i, 0));
                visited[i][0] = true;
                pq.add(new Cell(heightMap[i][n - 1], i, n - 1));
                visited[i][n - 1] = true;
            }
        }

        // Traverse all cells
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int x = cell.x;
            int y = cell.y;

            for (int[] direction : directions) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];

                if (nextX <= 0 || nextX >= m - 1 ||
                    nextY <= 0 || nextY >= n - 1 ||
                    visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                if (heightMap[nextX][nextY] < cell.height) {
                    amount += cell.height - heightMap[nextX][nextY];
                    pq.add(new Cell(cell.height, nextX, nextY));
                } else {
                    pq.add(new Cell(heightMap[nextX][nextY], nextX, nextY));
                }
            }
        }

        return amount;
    }

    private static class Cell {
        public int height;
        public int x;
        public int y;

        public Cell(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }
    }
}

