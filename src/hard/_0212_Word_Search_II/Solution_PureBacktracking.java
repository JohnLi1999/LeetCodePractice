package hard._0212_Word_Search_II;

import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/word-search-ii/
    Time complexity: O( N ⋅ M ⋅ 4⋅3^{L−1} )
        Where N is the number of words to be searched,
        M is the number of cells in the board, and L is the maximum length of words.
        To see more explanation, please check "0212. Word Search II.png"
    Space Complexity: O(N)
        Where N is the total number of letters in the dictionary.
        The main space consumed by the algorithm is the Trie data structure we build.
        In the worst case where there is no overlapping of prefixes among the words,
        the Trie would have as many nodes as the letters of all words.
        And optionally, one might keep a copy of words in the Trie as well.
        As a result, we might need 2N space for the Trie.
 */
public class Solution_PureBacktracking {
    private int ROWS;
    private int COLS;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<String> result = new LinkedList<>();

        for (String word : words) {
            if (searchWord(board, word)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean searchWord(char[][] board, String word) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(r, c, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, int index, String word) {
        if (index >= word.length()) {
            return true;
        }

        if (row < 0 || row >= ROWS ||
            col < 0 || col >= COLS ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        boolean result = false;
        board[row][col] = '#';

        // Check top, right, bottom, left
        if (backtrack(row + 1, col, index + 1, word) ||
                backtrack(row, col + 1, index + 1, word) ||
                backtrack(row - 1, col, index + 1, word) ||
                backtrack(row, col - 1, index + 1, word)) {
            /* Instead of returning directly once we find a match,
               we simply break out of the loop and do the cleanup before returning  */
            result = true;
        }

        board[row][col] = word.charAt(index);
        return result;
    }
}