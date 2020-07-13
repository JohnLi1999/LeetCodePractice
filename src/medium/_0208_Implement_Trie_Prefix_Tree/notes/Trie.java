package medium._0208_Implement_Trie_Prefix_Tree.notes;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*  Time complexity: O(m)
            Where m is the key length. In each iteration of the algorithm,
            we either examine or create a node in the trie till we reach the end of the key.
            This takes only m operations.
        Space complexity: O(m)
            In the worst case newly inserted key doesn't share a prefix with
            the the keys already inserted in the trie. We have to add m new nodes,
            which takes us O(m) space.
     */
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!currentNode.containsKey(currentChar)) {
                currentNode.put(currentChar, new TrieNode());
            }
            currentNode = currentNode.get(currentChar);
        }

        currentNode.setEndOfWord();
    }

    /*  Time complexity: O(m)
        Space complexity: O(1)
     */
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode result = searchPrefix(word);
        return result != null && result.isEndOfWord();
    }

    /*  Time complexity: O(m)
        Space complexity: O(1)
     */
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode result = searchPrefix(word);
        return result != null;
    }

    /*  Time complexity: O(m)
            In each step of the algorithm we search for the next key character.
            In the worst case the algorithm performs m operations.
        Space complexity: O(1)
     */
    /** Search a prefix or whole key in trie and returns the node where search ends */
    private TrieNode searchPrefix(String word) {
        TrieNode currentNode = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentNode.containsKey(currentChar)) {
                currentNode = currentNode.get(currentChar);
            } else {
                return null;
            }
        }

        return currentNode;
    }
}
