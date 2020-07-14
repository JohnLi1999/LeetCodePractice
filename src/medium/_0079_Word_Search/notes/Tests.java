package medium._0079_Word_Search.notes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    Backtracking_MyWay backtracking_myWay;

    @Nested
    class Board1 {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        @Test
        void test1() {
            backtracking_myWay = new Backtracking_MyWay();
            String word = "ABCCED";
            assertTrue(backtracking_myWay.exist(board, word));
        }

        @Test
        void test2() {
            backtracking_myWay = new Backtracking_MyWay();
            String word = "SEE";
            assertTrue(backtracking_myWay.exist(board, word));
        }

        @Test
        void test3() {
            backtracking_myWay = new Backtracking_MyWay();
            String word = "ABCB";
            assertFalse(backtracking_myWay.exist(board, word));
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
            backtracking_myWay = new Backtracking_MyWay();
            String word = "AAB";
            assertTrue(backtracking_myWay.exist(board, word));
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
            backtracking_myWay = new Backtracking_MyWay();
            String word = "ABCEFSADEESE";
            assertTrue(backtracking_myWay.exist(board, word));
        }
    }
}
