package medium._0208_Implement_Trie_Prefix_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
    TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        head.insert(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return head.search(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return head.startsWith(prefix);
    }

    public void printTrie() {
        TrieNode.printAllWordsInTrie(head);
    }
}

class TrieNode {
    public static final int ALPHABET_LENGTH = 26;
    public TrieNode[] nodes;
    public boolean isEndOfWord;

    public TrieNode() {
        nodes = new TrieNode[ALPHABET_LENGTH];
        isEndOfWord = false;
    }

    public void insert(String word) {
        TrieNode curr = this;
        for (int i = 0; i < word.length(); i++) {
            if (curr.nodes[word.charAt(i) - 'a'] == null) {
                curr.nodes[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.nodes[word.charAt(i) - 'a'];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        if ((boolean) find(word).get(0)) {
            return ((TrieNode) find(word).get(1)).isEndOfWord;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        return (boolean) find(prefix).get(0);
    }

    private List<Object> find(String word) {
        TrieNode curr = this;

        for (int i = 0; i < word.length(); i++) {
            TrieNode node = curr.nodes[word.charAt(i) - 'a'];

            if (node == null) {
                return List.of(false, curr);
            }

            curr = node;
        }

        return List.of(true, curr);
    }

    public static void printAllWordsInTrie(TrieNode head) {
        traverse(head, new StringBuilder());
    }

    private static void traverse(TrieNode head, StringBuilder sb) {
        if (head.isEndOfWord) {
            System.out.println(sb.toString());
        }
        for (int i = 0; i < head.nodes.length; i++) {
            if (head.nodes[i] != null) {
                traverse(head.nodes[i], sb.append((char) ('a' + i)));
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}