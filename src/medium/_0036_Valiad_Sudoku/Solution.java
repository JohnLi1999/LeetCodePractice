package medium._0036_Valiad_Sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /*  https://leetcode.com/problems/valid-sudoku/
        Time complexity: O(1)
            Since all we do here is just one iteration over the board with 81 cells.
            The board has a fixed size (9 * 9)
        Space complexity: O(1)
     */

    private Map<Integer, Set<Character>> rows = new HashMap<>();
    private Map<Integer, Set<Character>> cols = new HashMap<>();
    private Map<Integer, Set<Character>> boxes = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        // Iterate all numbers in the board
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                // Skip empty positions
                if (board[r][c] == '.') {
                    continue;
                }

                // Check if there is duplicate elements in a row, a column, or a box
                if (validate(r, c, board, "row") &&
                    validate(r, c, board, "col") &&
                    validate(r, c, board, "box")) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validate(int row, int col, char[][] board, String type) {
        Map<Integer, Set<Character>> map;
        int index;

        switch (type) {
            case "row":
                map = rows;
                index = row;
                break;
            case "col":
                map = cols;
                index = col;
                break;
            default:
                map = boxes;
                /*  Formula to get the index of the nine box areas
                       0 1 2 3 4 5 6 7 8
                       ----- ----- -----
                    0 |     |     |     |
                    1 |  0  |  1  |  2  |
                    2 |     |     |     |
                       ----- ----- -----
                    3 |     |     |     |
                    4 |  3  |  4  |  5  |
                    5 |     |     |     |
                       ----- ----- -----
                    6 |     |     |     |
                    7 |  6  |  7  |  8  |
                    8 |     |     |     |
                       ----- ----- -----
                 */
                index = (row / 3) * 3 + col / 3;
        }

        if (!map.containsKey(index)) {
            map.put(index, new HashSet<>());
        }
        if (map.get(index).contains(board[row][col])) {
            return false;
        }

        map.get(index).add(board[row][col]);
        return true;
    }
}
