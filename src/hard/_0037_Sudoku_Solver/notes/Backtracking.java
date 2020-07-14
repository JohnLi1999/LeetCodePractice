package hard._0037_Sudoku_Solver.notes;

/*  Time complexity: O(1)
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
public class Backtracking {
    // box size
    int n = 3;
    // row size
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
    /*
        Check if one could place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
    /*
        Place a number d in (row, col) cell
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void removeNumber(int d, int row, int col) {
    /*
        Remove a number which didn't lead to a solution
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
    /*
        Call backtrack function in recursion
        to continue to place numbers
        till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {
    /*
    Backtracking_MyWay
    */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        }
        else placeNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}
