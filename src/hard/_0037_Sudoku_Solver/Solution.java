package hard._0037_Sudoku_Solver;

import java.util.HashSet;

public class Solution {
    /*  https://leetcode.com/problems/sudoku-solver/
        Time complexity: O(1)
            It is constant here since the board size is fixed and there is no N-parameter to measure.
            Though let's discuss the number of operations needed: (9!)^9.
            Let's consider one row, i.e. not more than 99 cells to fill.
            There are not more than 9 possibilities for the first number to put,
            not more than 9 × 8 for the second one, not more than 9 × 8 × 7 for the third one etc.
            In total that results in not more than 9! possibilities for a just one row,
            that means not more than (9!)^9 operations in total. Let's compare:
            9^{81} = 196627050475552913618075908526912116283103450944214766927315415537966391196809
            for the brute force, and (9!)^9 = 109110688415571316480344899355894085582848000000000
            for the standard backtracking, i.e. the number of operations is reduced in 10^{27} times!
        Space complexity: O(1)
            The board size is fixed, and the space is used to
            store board, rows, columns and boxes structures, each contains 81 elements.
     */

    private HashSet<Character>[] rows;
    private HashSet<Character>[] cols;
    private HashSet<Character>[] boxes;
    private boolean foundSolution;

    public void solveSudoku(char[][] board) {
        initData(board);
        backtrack(0, 0, board);
    }

    private void initData(char[][] board) {
        int size = board.length;

        rows = new HashSet[size];
        cols = new HashSet[size];
        boxes = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char num = board[r][c];
                if (num != '.') {
                    int box_index = (r / 3) * 3 + c / 3;
                    rows[r].add(num);
                    cols[c].add(num);
                    boxes[box_index].add(num);
                }
            }
        }
    }

    private void backtrack(int row, int col, char[][] board) {
        if (foundSolution) {
            return;
        }

        if (row >= board.length) {
            foundSolution = true;
            return;
        }

        if (board[row][col] != '.') {
            placeNextNumber(row, col, board);
        } else {
            int box_index = (row / 3) * 3 + col / 3;
            for (char i = '1'; i <= '9'; i++) {
                if (rows[row].contains(i) || cols[col].contains(i) || boxes[box_index].contains(i)) {
                    continue;
                }

                board[row][col] = i;
                rows[row].add(i);
                cols[col].add(i);
                boxes[box_index].add(i);

                placeNextNumber(row, col, board);

                if (!foundSolution) {
                    board[row][col] = '.';
                    rows[row].remove(i);
                    cols[col].remove(i);
                    boxes[box_index].remove(i);
                }
            }
        }
    }

    private void placeNextNumber(int row, int col, char[][] board) {
        if (col == board.length - 1) {
            backtrack(row + 1, 0, board);
        } else {
            backtrack(row, col + 1, board);
        }
    }
}
