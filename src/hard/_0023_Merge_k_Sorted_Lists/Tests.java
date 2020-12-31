package hard._0023_Merge_k_Sorted_Lists;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.list_node.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    Solution_My_Way_Slow_Priority_Queue solutionMyWay = new Solution_My_Way_Slow_Priority_Queue();
    Solution_Better_Fast_Priority_Queue solution_betterFastPriorityQueue = new Solution_Better_Fast_Priority_Queue();
    Solution_Divide_and_Conquer_Recursive solution_divide_and_conquerRecursive = new Solution_Divide_and_Conquer_Recursive();
    Solution_Divide_and_Conquer_Iterative solution_divide_and_conquer_iterative = new Solution_Divide_and_Conquer_Iterative();

    ListNode[] createLists(int[][] matrix) {
        ListNode[] lists = new ListNode[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int[] list = matrix[i];
            ListNode node = new ListNode().arrayToListNodes(list);
            lists[i] = node;
        }

        return lists;
    }

    @Nested
    class Slow_Priority_Queue {
        @Test
        void test1() {
            int[][] matrix = {
                    { 1, 4, 5 },
                    { 1, 3, 4 },
                    { 2, 6 }
            };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
            assertEquals(expected, solutionMyWay.mergeKLists(lists));
        }

        @Test
        void test2() {
            int[][] matrix = {};
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solutionMyWay.mergeKLists(lists));
        }

        @Test
        void test3() {
            int[][] matrix = { {} };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solutionMyWay.mergeKLists(lists));
        }
    }

    @Nested
    class Fast_Priority_Queue {
        @Test
        void test1() {
            int[][] matrix = {
                    { 1, 4, 5 },
                    { 1, 3, 4 },
                    { 2, 6 }
            };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
            assertEquals(expected, solution_betterFastPriorityQueue.mergeKLists(lists));
        }

        @Test
        void test2() {
            int[][] matrix = {};
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_betterFastPriorityQueue.mergeKLists(lists));
        }

        @Test
        void test3() {
            int[][] matrix = { {} };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_betterFastPriorityQueue.mergeKLists(lists));
        }
    }

    @Nested
    class Divide_and_Conquer_Recursive {
        @Test
        void test1() {
            int[][] matrix = {
                    { 1, 4, 5 },
                    { 1, 3, 4 },
                    { 2, 6 }
            };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
            assertEquals(expected, solution_divide_and_conquerRecursive.mergeKLists(lists));
        }

        @Test
        void test2() {
            int[][] matrix = {};
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_divide_and_conquerRecursive.mergeKLists(lists));
        }

        @Test
        void test3() {
            int[][] matrix = { {} };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_divide_and_conquerRecursive.mergeKLists(lists));
        }
    }

    @Nested
    class Divide_and_Conquer_Iterative {
        @Test
        void test1() {
            int[][] matrix = {
                    { 1, 4, 5 },
                    { 1, 3, 4 },
                    { 2, 6 }
            };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
            assertEquals(expected, solution_divide_and_conquer_iterative.mergeKLists(lists));
        }

        @Test
        void test2() {
            int[][] matrix = {};
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_divide_and_conquer_iterative.mergeKLists(lists));
        }

        @Test
        void test3() {
            int[][] matrix = { {} };
            ListNode[] lists = createLists(matrix);
            ListNode expected = new ListNode().arrayToListNodes(new int[] {});
            assertEquals(expected, solution_divide_and_conquer_iterative.mergeKLists(lists));
        }
    }
}