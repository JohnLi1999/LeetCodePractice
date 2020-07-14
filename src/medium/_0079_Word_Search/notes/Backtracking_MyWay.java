package medium._0079_Word_Search.notes;

/*  Time Complexity: O(N * 4^L)
        Where N is the number of cells in the board and L is the length of the word to be matched.
        1.  For the backtracking function, its execution trace would be visualized as a 4-ary tree,
            each of the branches represent a potential exploration in the corresponding direction.
            Therefore, in the worst case, the total number of invocation would be
            the number of nodes in a full 4-nary tree, which is about 4^L.
        2.  We iterate through the board for backtracking, i.e. there could be N times invocation
            for the backtracking function in the worst case.
        3.  As a result, overall the time complexity of the algorithm would be O(N * 4^L).
    Space Complexity: O(L)
        Where L is the length of the word to be matched.
        The main consumption of the memory lies in the recursion call of the backtracking function.
        The maximum length of the call stack would be the length of the word.
        Therefore, the space complexity of the algorithm is O(L).
 */
public class Backtracking_MyWay {
    private int ROWS;
    private int COLS;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(r, c, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, int index, String word) {
        /* Step 1 - check the bottom case */
        if (index >= word.length()) {
            return true;
        }

        /* Step 2 - Check the boundaries */
        if (row < 0 || row >= ROWS ||
            col < 0 || col >= COLS ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        /* Step 3
            3.1 - Set the result to false initially
            3.2 - Mark the path before the next exploration
            3.3 - Explore the neighbors in DFS               */

        boolean result = false;
        board[row][col] = '#';

        // Check top, right, left, and bottom of the current position
        if (backtrack(row + 1, col, index + 1, word) ||
            backtrack(row, col + 1, index + 1, word) ||
            backtrack(row - 1, col, index + 1, word) ||
            backtrack(row, col - 1, index + 1, word)) {
            /* Instead of returning directly once we find a match,
               we simply break out of the loop and do the cleanup before returning  */
            result = true;
        }

        /* Step 4 - clean up and return the result */
        board[row][col] = word.charAt(index);

        return result;
    }
}
