package hard._0212_Word_Search_II;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class BacktrackingWithTrie {
        Solution_BacktrackingWithTrie solution;

        @Test
        void test1() {
            solution = new Solution_BacktrackingWithTrie();
            char[][] board = {
                    {'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','r'},
                    {'i','f','l','v'}
            };
            String[] words = {"oath", "pea", "eat", "rain"};
            List<String> expectedResult = List.of("oath", "eat");
            assertEquals(expectedResult, solution.findWords(board, words));
        }

        @Test
        void test2() {
            solution = new Solution_BacktrackingWithTrie();
            char[][] board = {
                    {'a','a'},
            };
            String[] words = {"a"};
            List<String> expectedResult = List.of("a");
            assertEquals(expectedResult, solution.findWords(board, words));
        }
    }

    @Nested
    class PureBackTracking {
        Solution_PureBacktracking solution;
        
        @Test
        void test() {
            solution = new Solution_PureBacktracking();
            char[][] board = {
                    {'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','r'},
                    {'i','f','l','v'}
            };
            String[] words = {"oath", "pea", "eat", "rain"};
            List<String> expectedResult = List.of("oath", "eat");
            assertEquals(expectedResult, solution.findWords(board, words));
        }
    }

    @Nested
    class Test_Trie {
        @Test
        void test() {
            Trie trie = new Trie();
            assertTrue(trie.startsWith(""));
            assertFalse(trie.search(""));
            trie.insert("apple");
            assertTrue(trie.search("apple"));
            assertFalse(trie.search("app"));
            assertTrue(trie.startsWith("app"));
            trie.insert("app");
            assertTrue(trie.search("app"));
            trie.insert("ant");
            assertFalse(trie.startsWith("at"));
        }
    }
}