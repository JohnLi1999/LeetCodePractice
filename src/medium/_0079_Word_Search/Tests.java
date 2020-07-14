package medium._0079_Word_Search;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    Solution solution = new Solution();

    @Nested
    class Board1 {
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        @Test
        void test1() {
            solution = new Solution();
            String word = "ABCCED";
            assertTrue(solution.exist(board, word));
        }

        @Test
        void test2() {
            solution = new Solution();
            String word = "SEE";
            assertTrue(solution.exist(board, word));
        }

        @Test
        void test3() {
            solution = new Solution();
            String word = "ABCB";
            assertFalse(solution.exist(board, word));
        }
    }

    @Nested
    class Board2 {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };

        @Test
        void test1() {
            solution = new Solution();
            String word = "AAB";
            assertTrue(solution.exist(board, word));
        }
    }

    @Nested
    class Board3 {
        char[][] board = {
                {'A', 'B', 'C', 'E'}, 
                {'S', 'F', 'E', 'S'}, 
                {'A', 'D', 'E', 'E'}
        };

        @Test
        void test1() {
            solution = new Solution();
            String word = "ABCEFSADEESE";
            assertTrue(solution.exist(board, word));
        }
    }
}