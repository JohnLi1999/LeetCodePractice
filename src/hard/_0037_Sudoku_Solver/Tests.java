package hard._0037_Sudoku_Solver;

import org.junit.jupiter.api.Test;

class Tests {

    Solution solution;

    void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.print("[ ");
            for (char num : row) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    @Test
    void test1() {
        solution = new Solution();
        char[][] board = {  {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}  };
        printBoard(board);
        solution.solveSudoku(board);
        printBoard(board);
    }
}