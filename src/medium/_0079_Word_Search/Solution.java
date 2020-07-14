package medium._0079_Word_Search;

public class Solution {
    /*  https://leetcode.com/problems/word-search/
        Time Complexity: O(N * 4^L)
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

    private int ROWS;
    private int COLS;
    private char[][] board;
    private int[] rowOffsets = {-1, 0, 1, 0};
    private int[] colOffsets = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] != word.charAt(0)) {
                    continue;
                }

                if (backtrack(r, c, new boolean[ROWS][COLS], 1, word, new StringBuilder())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, boolean[][] used, int index, String word, StringBuilder sb) {
        sb.append(board[row][col]);
        used[row][col] = true;

        if (sb.toString().equals(word)) {
            return true;
        } else if (sb.length() >= word.length()) {
            return false;
        }

        for (int i = 0; i < rowOffsets.length; i++) {
            int nextRow = row + rowOffsets[i];
            int nextCol = col + colOffsets[i];

            if (nextRow < 0 || nextRow >= ROWS ||
                nextCol < 0 || nextCol >= COLS ||
                used[nextRow][nextCol] ||
                board[nextRow][nextCol] != word.charAt(index)) {
                continue;
            }

            boolean found = backtrack(nextRow, nextCol, used, index + 1, word, sb);
            if (!found) {
                sb.delete(sb.length() - 1, sb.length());
                used[nextRow][nextCol] = false;
            } else {
                return true;
            }
        }

        return false;
    }
}