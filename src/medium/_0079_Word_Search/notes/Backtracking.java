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
public class Backtracking {
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row)
            for (int col = 0; col < this.COLS; ++col)
                if (this.backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                || this.board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        boolean ret = false;
        // mark the path before the next exploration
        this.board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            /* Instead of returning directly once we find a match,
               we simply break out of the loop and do the cleanup before returning  */
            if (ret)
                break;
        }

        /* Step 4). clean up and return the result. */
        this.board[row][col] = word.charAt(index);
        return ret;
    }
}