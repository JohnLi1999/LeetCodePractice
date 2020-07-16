package hard._0212_Word_Search_II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*  https://leetcode.com/problems/word-search-ii/
    Time complexity: O( M(4⋅3^{L−1}) )
        Where M is the number of cells in the board and L is the maximum length of words.
        To see more explanation, please check "0212. Word Search II.png"
    Space Complexity: O(N)
        Where N is the total number of letters in the dictionary.
        The main space consumed by the algorithm is the Trie data structure we build.
        In the worst case where there is no overlapping of prefixes among the words,
        the Trie would have as many nodes as the letters of all words.
        And optionally, one might keep a copy of words in the Trie as well.
        As a result, we might need 2N space for the Trie.
 */
public class Solution_BacktrackingWithTrie {
    private int ROWS;
    private int COLS;
    private char[][] board;
    private List<String> results;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.results = new LinkedList<>();

        // Construct the Trie
        trie = new Trie();
        Arrays.stream(words).forEach(trie::insert);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                backtrack(r, c, new StringBuilder());
            }
        }

        return results;
    }

    private void backtrack(int row, int col, StringBuilder temp) {
        // Check boundaries and whether the current position is used or not
        if (row < 0 || row >= ROWS ||
            col < 0 || col >= COLS ||
            board[row][col] == '#') {
            return;
        }

        // Append the current char into temp result
        temp.append(board[row][col]);


        // Return if the current string does not match any prefix in the trie
        if (!trie.startsWith(temp.toString())) {
            // Clean up temp result
            temp.delete(temp.length() - 1, temp.length());
            return;
        }

        // Mark the current cell as used
        board[row][col] = '#';

        // Add matched words and avoid duplicates
        if (trie.search(temp.toString()) && !results.contains(temp.toString())) {
            results.add(temp.toString());
        }

        // Check top, right, bottom, left cells of the current cell
        backtrack(row - 1, col, temp);
        backtrack(row, col + 1, temp);
        backtrack(row + 1, col, temp);
        backtrack(row, col - 1, temp);

        // Clean up the board and temp result
        board[row][col] = temp.charAt(temp.length() - 1);
        temp.delete(temp.length() - 1, temp.length());
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.containsKey(c)) {
                curr.put(c, new TrieNode());
            }

            curr = curr.get(c);
        }

        curr.setEndOfWord();
    }

    public boolean search(String word) {
        TrieNode result = find(word);
        return result != null && result.isEndOfWord();
    }

    public boolean startsWith(String word) {
        TrieNode result = find(word);
        return result != null;
    }

    private TrieNode find(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.containsKey(c)) {
                curr = curr.get(c);
            } else {
                return null;
            }
        }

        return curr;
    }
}

class TrieNode {
    private static final int ALPHABET_LENGTH = 26;
    private TrieNode[] links;
    private boolean isEndOfWord;

    public TrieNode() {
        links = new TrieNode[ALPHABET_LENGTH];
        isEndOfWord = false;
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }
}
