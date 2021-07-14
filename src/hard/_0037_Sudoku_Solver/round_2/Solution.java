package hard._0037_Sudoku_Solver.round_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = new char[][] {
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

        s.solveSudoku(board);

        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private final List<Set<Character>> rows = new ArrayList<>();
    private final List<Set<Character>> cols = new ArrayList<>();
    private final List<Set<Character>> grids = new ArrayList<>();
    private char[][] board;
    private boolean isSuccess = false;

    /*  Time complexity: O(1)
            Number of operations: (9!)^9
                9! operations for onw row and we have 9 rows in total
        Space complexity: O(1)
     */
    public void solveSudoku(char[][] board) {
        this.board = board;
        init();

        solve(0, 0);
    }

    public void solve(int row, int col) {
        // Success
        if (row == board.length) {
            isSuccess = true;
            return;
        }

        if (board[row][col] != '.') {
            if (col == board.length - 1) {
                solve(row + 1, 0);
            } else {
                solve(row, col + 1);
            }

            return;
        }

        for (int num = 1; num <= board.length; num++) {
            char n = Character.forDigit(num, 10);

            if (rows.get(row).contains(n) ||
                cols.get(col).contains(n) ||
                grids.get(gridIndex(row, col)).contains(n)) {
                continue;
            }

            rows.get(row).add(n);
            cols.get(col).add(n);
            grids.get(gridIndex(row, col)).add(n);

            board[row][col] = n;

            if (col == board.length - 1) {
                solve(row + 1, 0);
            } else {
                solve(row, col + 1);
            }

            if (isSuccess) {
                break;
            }

            board[row][col] = '.';
            rows.get(row).remove(n);
            cols.get(col).remove(n);
            grids.get(gridIndex(row, col)).remove(n);
        }
    }

    public void init() {
        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grids.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                rows.get(i).add(c);
                cols.get(j).add(c);
                grids.get(gridIndex(i, j)).add(c);
            }
        }
    }

    public int gridIndex(int row, int col) {
        return row / 3 * 3 + col / 3;
    }
}
