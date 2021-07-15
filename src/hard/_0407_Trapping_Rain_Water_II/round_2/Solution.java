package hard._0407_Trapping_Rain_Water_II.round_2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] heightMap1 = new int[][] {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(s.trapRainWater(heightMap1));

        int[][] heightMap2 = new int[][] {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        System.out.println(s.trapRainWater(heightMap2));
    }

    /*  Key idea: Save the cell with height, then traverse
                  each of them for lowest to highest using a min heap
        Time complexity: O(m * n * log(m + n))
            m -> width of the heightMap
            n -> length of the heightMap
        Space complexity: O(m + n)
     */
    public int trapRainWater(int[][] heightMap) {
        int width = heightMap.length;
        int length = heightMap[0].length;
        boolean[][] visited = new boolean[width][length];
        int volume = 0;
        int[] rowOffsets = new int[] {-1, 0, 1, 0};
        int[] colOffsets = new int[] {0, 1, 0, -1};

        PriorityQueue<Cell> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(cell -> cell.height)
        );

        // Step 1: Add border cells into the min heap
        for (int row = 0; row < width; row++) {
            minHeap.add(new Cell(row, 0, heightMap[row][0]));
            minHeap.add(new Cell(row, length - 1, heightMap[row][length - 1]));

            visited[row][0] = true;
            visited[row][length - 1] = true;
        }
        for (int col = 0; col < length; col++) {
            minHeap.add(new Cell(0, col, heightMap[0][col]));
            minHeap.add(new Cell(width - 1, col, heightMap[width - 1][col]));

            visited[0][col] = true;
            visited[width - 1][col] = true;
        }

        /*  Step 2: Poll out the cell that has the lowest height
                    from the min heap until it is empty
         */
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Step 2.1: Check the four directions of the polled out cell
            for (int direction = 0; direction < 4; direction++) {
                int nextRow = cell.row + rowOffsets[direction];
                int nextCol = cell.col + colOffsets[direction];

                // Step 2.2: Continue if the position is valid and the new cell has not been not visited yet
                if (nextRow >= 0 && nextRow < width &&
                    nextCol >= 0 && nextCol < length && !visited[nextRow][nextCol]) {

                    /*  Step 2.3:
                            1. Mark the new cell as visited
                            2. If the new cell is higher than the current cell,
                               add the difference of the height to the volume
                            3. Add the new cell into the min heap with the higher height
                     */
                    visited[nextRow][nextCol] = true;
                    volume += Math.max(0, cell.height - heightMap[nextRow][nextCol]);
                    minHeap.add(new Cell(nextRow, nextCol, Math.max(cell.height, heightMap[nextRow][nextCol])));
                }
            }
        }

        return volume;
    }
}

class Cell {
    int row;
    int col;
    int height;

    public Cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
