package medium._0208_Implement_Trie_Prefix_Tree.notes;

public class TrieNode {
    /*  Number of links to node children.
        We assume this Trie only has lowercase letters
     */
    private static final int ALPHABET_LENGTH = 26;

    private TrieNode[] links;
    private boolean isEndOfWord;

    public TrieNode() {
        links = new TrieNode[ALPHABET_LENGTH];
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
