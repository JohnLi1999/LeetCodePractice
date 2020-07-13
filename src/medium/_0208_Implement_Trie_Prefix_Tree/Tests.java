package medium._0208_Implement_Trie_Prefix_Tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test() {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("a");
        trie.insert("b");
        trie.insert("dbc");
        trie.insert("ab");
        trie.insert("xxx");
        trie.insert("xxxx");
        trie.insert("xxxxxxxxxxx");
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
        trie.insert("ant");
        assertFalse(trie.startsWith("at"));

        trie.printTrie();
    }
}