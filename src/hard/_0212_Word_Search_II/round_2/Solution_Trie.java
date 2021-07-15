package hard._0212_Word_Search_II.round_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Trie {
    public static void main(String[] args) {
        Solution_Trie s = new Solution_Trie();
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
                {'a'}
        };
        String[] words2 = new String[] {"a"};
        List<String> output2 = s.findWords(board2, words2);
        System.out.println(output2.toString());
        char[][] board3 = {
                {'a','a'},
                {'a','a'}
        };
        String[] words3 = new String[] {"aaaaa"};
        List<String> output3 = s.findWords(board3, words3);
        System.out.println(output3.toString());
    }

    private char[][] board;
    private boolean[][] visited;
    private List<String> results;
    private Trie trie;
    private final int[] rowOffsets = new int[] {-1, 0, 1, 0};
    private final int[] colOffsets = new int[] {0, 1, 0, -1};

    /*  Time complexity: O(M * (4 * 3^(L-1)))
            M -> number of letters on the board
            L -> maximum length of words
        Space complexity: O(M)
            M for the visited array
     */
    public List<String> findWords(char[][] board, String[] words) {
        init(board, words);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                TrieNode node = trie.root;
                find(row, col, node);
            }
        }

        return results;
    }

    public void find(int row, int col, TrieNode node) {
        char c = board[row][col];

        if (!visited[row][col] && node.children.get(c) != null) {
            visited[row][col] = true;

            TrieNode nextNode = node.children.get(c);
            if (nextNode.word != null) {
                results.add(nextNode.word);
                nextNode.word = null;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + rowOffsets[direction];
                int nextCol = col + colOffsets[direction];

                if (nextRow >= 0 && nextRow < board.length &&
                    nextCol >= 0 && nextCol < board[0].length) {
                    find(nextRow, nextCol, nextNode);
                }
            }

            visited[row][col] = false;

            // Optimization: remove leaf nodes
            if (nextNode.children.isEmpty()) {
                node.children.remove(c);
            }
        }
    }

    public void init(char[][] board, String[] words) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        results = new ArrayList<>();
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
    }
}


class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = word;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    public TrieNode() {
        children = new HashMap<>();
    }
}