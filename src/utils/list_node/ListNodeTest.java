package utils.list_node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void testPrintList() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        ListNode.printList(list); // 1 -> 2
    }

    @Test
    void testArrayToListNode() {
        ListNode.printList(new ListNode().arrayToListNodes(new int[] {3, 4, 2})); // 3 -> 4 -> 2
        ListNode.printList(new ListNode().arrayToListNodes(new int[] {1, 9, 8})); // 1 -> 9 -> 8
    }

    @Test
    void testArrayToListNodeReverse() {
        ListNode.printList(new ListNode().arrayToListNodesReverse(new int[] {3, 4, 2})); // 2 -> 4 -> 3
        ListNode.printList(new ListNode().arrayToListNodesReverse(new int[] {1, 9, 8})); // 8 -> 9 -> 1
    }
}