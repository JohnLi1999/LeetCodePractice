package medium._0547_Friend_Circles;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class BFS {

        Solution_BFS solution_bfs = new Solution_BFS();

        @Test
        void test1() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 0},
                            {0, 0, 1}   };
            assertEquals(2, solution_bfs.findCircleNum(M));
        }

        @Test
        void test2() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 1},
                            {0, 1, 1}   };
            assertEquals(1, solution_bfs.findCircleNum(M));
        }

        @Test
        void test3() {
            int[][] M = {   {1, 1, 0, 1},
                            {1, 1, 0, 1},
                            {0, 0, 1, 0},
                            {0, 1, 0, 1}   };
            assertEquals(2, solution_bfs.findCircleNum(M));
        }
    }

    @Nested
    class DFS {

        Solution_DFS solution_dfs = new Solution_DFS();

        @Test
        void test1() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 0},
                            {0, 0, 1}   };
            assertEquals(2, solution_dfs.findCircleNum(M));
        }

        @Test
        void test2() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 1},
                            {0, 1, 1}   };
            assertEquals(1, solution_dfs.findCircleNum(M));
        }

        @Test
        void test3() {
            int[][] M = {   {1, 1, 0, 1},
                            {1, 1, 0, 1},
                            {0, 0, 1, 0},
                            {0, 1, 0, 1}   };
            assertEquals(2, solution_dfs.findCircleNum(M));
        }
    }

    @Nested
    class Disjoint_Set {

        Solution_Disjoint_Set solution_disjoint_set = new Solution_Disjoint_Set();

        @Test
        void test1() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 0},
                            {0, 0, 1}   };
            assertEquals(2, solution_disjoint_set.findCircleNum(M));
        }

        @Test
        void test2() {
            int[][] M = {   {1, 1, 0},
                            {1, 1, 1},
                            {0, 1, 1}   };
            assertEquals(1, solution_disjoint_set.findCircleNum(M));
        }

        @Test
        void test3() {
            int[][] M = {   {1, 1, 0, 1},
                            {1, 1, 0, 1},
                            {0, 0, 1, 0},
                            {0, 1, 0, 1}   };
            assertEquals(2, solution_disjoint_set.findCircleNum(M));
        }
    }
}