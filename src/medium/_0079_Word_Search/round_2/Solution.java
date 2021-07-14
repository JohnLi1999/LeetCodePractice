package medium._0079_Word_Search.round_2;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board1 = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        System.out.println(s.exist(board1, word1));
        String word2 = "SEE";
        System.out.println(s.exist(board1, word2));
        String word3 = "ABCB";
        System.out.println(s.exist(board1, word3));

        char[][] board2 = new char[][] {
                {'A'}
        };
        String word4 = "A";
        System.out.println(s.exist(board2, word4));

        char[][] board3 = new char[][] {
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        };
        String word5 = "aaaaaaaaaaaaa";
        System.out.println(s.exist(board3, word5));
    }

    private char[][] board;
    private boolean[][] visited;
    private final int[] rowOffsets = new int[] {-1, 0, 1, 0};
    private final int[] colOffsets = new int[] {0, 1, 0, -1};

    /*  Time complexity: O((m * n) * 4^L)
            m * n -> board size
            L -> word length
        Space complexity: O(m * n)
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (search(row, col, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(int row, int col, int index, String word) {
        char c = word.charAt(index);
        if (!visited[row][col] && board[row][col] == c) {
            visited[row][col] = true;

            if (index + 1 >= word.length()) {
                return true;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + rowOffsets[direction];
                int nextCol = col + colOffsets[direction];
                if (nextRow >= 0 && nextRow < board.length &&
                    nextCol >= 0 && nextCol < board[0].length) {
                    if (search(nextRow, nextCol, index + 1, word)) {
                        return true;
                    }
                }
            }

            visited[row][col] = false;
        }

        return false;
    }
}
