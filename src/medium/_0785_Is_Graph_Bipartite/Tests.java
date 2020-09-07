package medium._0785_Is_Graph_Bipartite;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {


    @Nested
    class Using_Queue {
        Solution_Queue solution = new Solution_Queue();

        @Test
        void test1() {
            int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
            assertTrue(solution.isBipartite(graph));
        }

        @Test
        void test2() {
            int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test3() {
            int[][] graph = new int[][]{
                    {}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test4() {
            int[][] graph = new int[][]{
                    {2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test5() {
            int[][] graph = new int[][]{
                    {3},{2,4},{1},{0,4},{1,3}
            };
            assertTrue(solution.isBipartite(graph));
        }


        @Test
        void test6() {
            int[][] graph = new int[][]{{}};
            assertTrue(solution.isBipartite(graph));
        }
    }

    @Nested
    class Using_Stack {
        Solution_Stack solution = new Solution_Stack();

        @Test
        void test1() {
            int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
            assertTrue(solution.isBipartite(graph));
        }

        @Test
        void test2() {
            int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test3() {
            int[][] graph = new int[][]{
                    {}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test4() {
            int[][] graph = new int[][]{
                    {2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test5() {
            int[][] graph = new int[][]{
                    {3},{2,4},{1},{0,4},{1,3}
            };
            assertTrue(solution.isBipartite(graph));
        }


        @Test
        void test6() {
            int[][] graph = new int[][]{{}};
            assertTrue(solution.isBipartite(graph));
        }
    }

    @Nested
    class Two_ArrayLists {
        Solution_Super_Slow solution = new Solution_Super_Slow();

        @Test
        void test1() {
            int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
            assertTrue(solution.isBipartite(graph));
        }

        @Test
        void test2() {
            int[][] graph = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test3() {
            int[][] graph = new int[][]{
                    {}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test4() {
            int[][] graph = new int[][]{
                    {2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}
            };
            assertFalse(solution.isBipartite(graph));
        }

        @Test
        void test5() {
            int[][] graph = new int[][]{
                    {3},{2,4},{1},{0,4},{1,3}
            };
            assertTrue(solution.isBipartite(graph));
        }


        @Test
        void test6() {
            int[][] graph = new int[][]{{}};
            assertTrue(solution.isBipartite(graph));
        }
    }
}