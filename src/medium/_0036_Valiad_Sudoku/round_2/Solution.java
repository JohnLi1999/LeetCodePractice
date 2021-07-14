package medium._0036_Valiad_Sudoku.round_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board1 = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'}, 
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] board2 = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(s.isValidSudoku(board1));
        System.out.println(s.isValidSudoku(board2));
    }

    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> grids = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grids.add(new HashSet<>());
        }

        /*
               0  1  2  3  4  5  6  7  8
            0
            1     0        1        2
            2
            3
            4     3        4        5
            5
            6
            7     6        7        8
            8
         */

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];

                if (c == '.') {
                    continue;
                }
                if (rows.get(row).contains(c) ||
                    cols.get(col).contains(c) ||
                    grids.get(gridIndex(row, col)).contains(c)) {
                    return false;
                }

                rows.get(row).add(c);
                cols.get(col).add(c);
                grids.get(gridIndex(row, col)).add(c);
            }
        }

        return true;
    }

    public int gridIndex(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
