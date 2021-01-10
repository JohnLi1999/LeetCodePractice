package medium._0417_Pacific_Atlantic_Water_Flow;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

    @Nested
    class Sample {

        Solution_Sample_BFS solution_sample_BFS = new Solution_Sample_BFS();

        @Test
        void test1() {
            int[][] matrix = new int[][] {
                    { 1, 2, 2, 3, 5 },
                    { 3, 2, 3, 4, 4 },
                    { 2, 4, 5, 3, 1 },
                    { 6, 7, 1, 4, 5 },
                    { 5, 1, 1, 2, 4 }
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 4), List.of(1, 3),  List.of(1, 4), List.of(2, 2), List.of(3, 0),
                    List.of(3, 1), List.of(4, 0)
            );
            List<List<Integer>> results = solution_sample_BFS.pacificAtlantic(matrix);
            results.sort(Comparator.comparingInt(list -> list.get(0)));
            assertEquals(expected, results);
        }

        @Test
        void test2() {
            int[][] matrix = new int[][] {
                    { 1, 2, 2, 3, 5 },
                    { 3, 2, 3, 4, 4 },
                    { 2, 4, 5, 3, 1 },
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 4), List.of(1, 0), List.of(1, 3), List.of(1, 4), List.of(2, 0),
                    List.of(2, 1), List.of(2, 2)
            );
            List<List<Integer>> results = solution_sample_BFS.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test3() {
            int[][] matrix = new int[][] {};
            List<List<Integer>> expected = List.of();
            List<List<Integer>> results = solution_sample_BFS.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test4() {
            int[][] matrix = new int[][] {
                    {}
            };
            List<List<Integer>> expected = List.of();
            List<List<Integer>> results = solution_sample_BFS.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test5() {
            int[][] matrix = new int[][] {
                    { 1,   2,  3, 4 },
                    { 12, 13, 14, 5 },
                    { 11, 16, 15, 6 },
                    { 10,  9,  8, 7 }
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 3), List.of(1, 0), List.of(1, 1), List.of(1, 2), List.of(1, 3),
                    List.of(2, 0), List.of(2, 1), List.of(2, 2), List.of(2, 3), List.of(3, 0),
                    List.of(3, 1), List.of(3, 2), List.of(3, 3)
            );
            List<List<Integer>> results = solution_sample_BFS.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }
    }


    @Nested
    class My_Way {

        Solution_My_Way solution_my_way = new Solution_My_Way();

        @Test
        void test1() {
            int[][] matrix = new int[][] {
                    { 1, 2, 2, 3, 5 },
                    { 3, 2, 3, 4, 4 },
                    { 2, 4, 5, 3, 1 },
                    { 6, 7, 1, 4, 5 },
                    { 5, 1, 1, 2, 4 }
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 4), List.of(1, 3),  List.of(1, 4), List.of(2, 2), List.of(3, 0),
                    List.of(3, 1), List.of(4, 0)
            );
            List<List<Integer>> results = solution_my_way.pacificAtlantic(matrix);
            results.sort(Comparator.comparingInt(list -> list.get(0)));
            assertEquals(expected, results);
        }

        @Test
        void test2() {
            int[][] matrix = new int[][] {
                    { 1, 2, 2, 3, 5 },
                    { 3, 2, 3, 4, 4 },
                    { 2, 4, 5, 3, 1 },
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 4), List.of(1, 0), List.of(1, 3), List.of(1, 4), List.of(2, 0),
                    List.of(2, 1), List.of(2, 2)
            );
            List<List<Integer>> results = solution_my_way.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test3() {
            int[][] matrix = new int[][] {};
            List<List<Integer>> expected = List.of();
            List<List<Integer>> results = solution_my_way.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test4() {
            int[][] matrix = new int[][] {
                    {}
            };
            List<List<Integer>> expected = List.of();
            List<List<Integer>> results = solution_my_way.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }

        @Test
        void test5() {
            int[][] matrix = new int[][] {
                    { 1,   2,  3, 4 },
                    { 12, 13, 14, 5 },
                    { 11, 16, 15, 6 },
                    { 10,  9,  8, 7 }
            };
            List<List<Integer>> expected = List.of(
                    List.of(0, 3), List.of(1, 0), List.of(1, 1), List.of(1, 2), List.of(1, 3),
                    List.of(2, 0), List.of(2, 1), List.of(2, 2), List.of(2, 3), List.of(3, 0),
                    List.of(3, 1), List.of(3, 2), List.of(3, 3)
            );
            List<List<Integer>> results = solution_my_way.pacificAtlantic(matrix);
            results.sort((o1, o2) -> {
                int firstDiff = o1.get(0) - o2.get(0);
                if (firstDiff < 0) {
                    return -1;
                } else if (firstDiff == 0) {
                    return o1.get(1) - o2.get(1);
                } else {
                    return 1;
                }
            });
            assertEquals(expected, results);
        }
    }
}