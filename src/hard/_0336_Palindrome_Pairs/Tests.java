package hard._0336_Palindrome_Pairs;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class Trie {
        Solution_Trie solution_trie = new Solution_Trie();

        @Test
        void test1() {
            String[] words = {
                    "abcd", "dcba", "lls", "s", "sssll"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0), List.of(2, 4), List.of(3, 2)
            );
            assertEquals(expected, solution_trie.palindromePairs(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "bat", "tab", "cat"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0)
            );
            assertEquals(expected, solution_trie.palindromePairs(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "a",""
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0)
            );
            assertEquals(expected, solution_trie.palindromePairs(words));
        }
    }

    @Nested
    class HashMap {
        Solution_HashMap solution_hashMap = new Solution_HashMap();

        @Test
        void test1() {
            String[] words = {
                    "abcd", "dcba", "lls", "s", "sssll"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)
            );
            assertEquals(expected, solution_hashMap.palindromePairs(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "bat", "tab", "cat"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0)
            );
            assertEquals(expected, solution_hashMap.palindromePairs(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "a",""
            };
            List<List<Integer>> expected = List.of(
                    List.of(1, 0), List.of(0, 1)
            );
            assertEquals(expected, solution_hashMap.palindromePairs(words));
        }
    }

    @Nested
    class My_Way {
        Solution_My_Way solution_my_way = new Solution_My_Way();

        @Test
        void test1() {
            String[] words = {
                    "abcd", "dcba", "lls", "s", "sssll"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4)
            );
            assertEquals(expected, solution_my_way.palindromePairs(words));
        }

        @Test
        void test2() {
            String[] words = {
                    "bat", "tab", "cat"
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0)
            );
            assertEquals(expected, solution_my_way.palindromePairs(words));
        }

        @Test
        void test3() {
            String[] words = {
                    "a",""
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 1), List.of(1, 0)
            );
            assertEquals(expected, solution_my_way.palindromePairs(words));
        }
    }
}