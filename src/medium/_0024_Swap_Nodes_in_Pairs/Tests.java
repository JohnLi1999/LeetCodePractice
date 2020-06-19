package medium._0024_Swap_Nodes_in_Pairs;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.list_node.ListNode;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0024_Swap_Nodes_in_Pairs.Solution.swapPairs_Iterative;
import static medium._0024_Swap_Nodes_in_Pairs.Solution.swapPairs_Recursive;

class Tests {

    @Nested
    class Iterative {
        @Test
        void test1() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {4, 3, 2, 1});
            ListNode.printList(swapPairs_Iterative(input)); // 2 -> 1 -> 4 -> 3
        }

        @Test
        void test2() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {3, 2, 1});
            ListNode.printList(swapPairs_Iterative(input)); // 2 -> 1 -> 3
        }

        @Test
        void test3() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {2, 1});
            ListNode.printList(swapPairs_Iterative(input)); // 2 -> 1
        }

        @Test
        void test4() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {1});
            ListNode.printList(swapPairs_Iterative(input)); // 1
        }

        @Test
        void test5() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {5, 1, 2, 9, 8, 7, 3, 1, 2, 7, 3, 8, 9, 1, 2});
            ListNode.printList(swapPairs_Iterative(input)); // 1 -> 2 -> 8 -> 9 -> 7 -> 3 -> 1 -> 2 -> 7 -> 3 -> 9 -> 8 -> 1 -> 2 -> 5
        }
    }

    @Nested
    class Recursive {
        @Test
        void test1() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {4, 3, 2, 1});
            ListNode.printList(swapPairs_Recursive(input)); // 2 -> 1 -> 4 -> 3
        }

        @Test
        void test2() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {3, 2, 1});
            ListNode.printList(swapPairs_Recursive(input)); // 2 -> 1 -> 3
        }

        @Test
        void test3() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {2, 1});
            ListNode.printList(swapPairs_Recursive(input)); // 2 -> 1
        }

        @Test
        void test4() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {1});
            ListNode.printList(swapPairs_Recursive(input)); // 1
        }

        @Test
        void test5() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {5, 1, 2, 9, 8, 7, 3, 1, 2, 7, 3, 8, 9, 1, 2});
            ListNode.printList(swapPairs_Recursive(input)); // 1 -> 2 -> 8 -> 9 -> 7 -> 3 -> 1 -> 2 -> 7 -> 3 -> 9 -> 8 -> 1 -> 2 -> 5
        }
    }
}