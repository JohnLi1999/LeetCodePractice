package hard._0212_Word_Search_II.round_2;

import java.util.ArrayList;
import java.util.List;

public class Solution_PureBacktrack {
    public static void main(String[] args) {
        Solution_PureBacktrack s = new Solution_PureBacktrack();
        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words1 = new String[] {"oath","pea","eat","rain"};
        List<String> output1 = s.findWords(board1, words1);
        System.out.println(output1.toString());
        char[][] board2 = {
                {'a','a'},
                {'a','a'},
        };
        String[] words2 = new String[] {"aaaaa"};
        List<String> output2 = s.findWords(board2, words2);
        System.out.println(output2.toString());
    }

    private char[][] board;
    private boolean[][] visited;
    private List<String> results;
    private final int[] rowOffsets = new int[] {-1, 0, 1, 0};
    private final int[] colOffsets = new int[] {0, 1, 0, -1};

    /*  Time complexity: O(M * (4 * 3^(L-1)))
            M -> number of letters on the board
            L -> maximum length of words
        Space complexity: O(max(M, N))
            N -> number of words in the trie
            M for the visited array, N for the constructed array
     */
    public List<String> findWords(char[][] board, String[] words) {
        init(board, words);

        for (String word : words) {
            visited = new boolean[board.length][board[0].length];
            if (search(word)) {
                results.add(word);
            }
        }

        return results;
    }

    public boolean search(String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (find(row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(int row, int col, int index, String word) {
        if (!visited[row][col] && word.charAt(index) == board[row][col]) {
            visited[row][col] = true;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + rowOffsets[direction];
                int nextCol = col + colOffsets[direction];
                int nexIndex = index + 1;

                if (nexIndex >= word.length()) {
                    return true;
                }

                if (nextRow >= 0 && nextRow < board.length &&
                    nextCol >= 0 && nextCol < board[0].length) {
                    if (find(nextRow, nextCol, nexIndex, word)) {
                        return true;
                    }
                }
            }

            visited[row][col] = false;
        }

        return false;
    }

    public void init(char[][] board, String[] words) {
        this.board = board;
        results = new ArrayList<>();
    }
}
