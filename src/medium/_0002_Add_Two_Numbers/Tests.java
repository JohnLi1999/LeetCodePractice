package medium._0002_Add_Two_Numbers;

import org.junit.jupiter.api.Test;
import utils.list_node.ListNode;

import static medium._0002_Add_Two_Numbers.Solution.addTwoNumbers;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        ListNode l1 = new ListNode().arrayToListNodes(new int[] {3, 4, 2});
        ListNode l2 = new ListNode().arrayToListNodes(new int[] {4, 6, 5});
        ListNode expectedResult = new ListNode().arrayToListNodes(new int[] {8, 0, 7});
        ListNode.printList(l1); // 2 -> 4 -> 3
        ListNode.printList(l2); // 5 -> 6 -> 4
        ListNode.printList(expectedResult); // 7 -> 0 -> 8
        ListNode.printList(addTwoNumbers(l1, l2));  // 7 -> 0 -> 8
    }

    @Test
    void test2() {
        ListNode l1 = new ListNode().arrayToListNodes(new int[] {3, 9, 9, 9});
        ListNode l2 = new ListNode().arrayToListNodes(new int[] {4, 1, 1, 1});
        ListNode expectedResult = new ListNode().arrayToListNodes(new int[] {8, 1, 1, 0});
        ListNode.printList(l1); // 9 -> 9 -> 9 -> 3
        ListNode.printList(l2); // 1 -> 1 -> 1 -> 4
        ListNode.printList(expectedResult); // 0 -> 1 -> 1 -> 8
        ListNode.printList(addTwoNumbers(l1, l2));  // 0 -> 1 -> 1 -> 8
    }

    @Test
    void test3() {
        ListNode l1 = new ListNode().arrayToListNodes(new int[] {9, 9, 9, 9});
        ListNode l2 = new ListNode().arrayToListNodes(new int[] {1, 1});
        ListNode expectedResult = new ListNode().arrayToListNodes(new int[] {1, 0, 0, 1, 0});
        ListNode.printList(l1); // 9 -> 9 -> 9 -> 9
        ListNode.printList(l2); // 1 -> 1
        ListNode.printList(expectedResult); // 0 -> 1 -> 0 -> 0 -> 1
        ListNode.printList(addTwoNumbers(l1, l2)); // 0 -> 1 -> 0 -> 0 -> 1
    }
}