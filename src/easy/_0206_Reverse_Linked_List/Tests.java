package easy._0206_Reverse_Linked_List;

import org.junit.jupiter.api.Test;
import utils.list_node.ListNode;

import static easy._0206_Reverse_Linked_List.Solution.reverseList_Iterative;
import static easy._0206_Reverse_Linked_List.Solution.reverseList_Recursive;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {5, 4, 3, 2, 1});
        ListNode.printList(head);
        ListNode reverse = reverseList_Iterative(head);
        ListNode.printList(reverse);
    }

    @Test
    void test2() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {1});
        ListNode.printList(head);
        ListNode reverse = reverseList_Iterative(head);
        ListNode.printList(reverse);
    }


    @Test
    void test3() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {1, 2, 3, 4, 4, 5, 5, 100});
        ListNode.printList(head);
        ListNode reverse = reverseList_Iterative(head);
        ListNode.printList(reverse);
    }

    @Test
    void test4() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {5, 4, 3, 2, 1});
        ListNode.printList(head);
        ListNode reverse = reverseList_Recursive(head);
        ListNode.printList(reverse);
    }

    @Test
    void test5() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {1});
        ListNode.printList(head);
        ListNode reverse = reverseList_Recursive(head);
        ListNode.printList(reverse);
    }


    @Test
    void test6() {
        ListNode head = new ListNode().arrayToListNodes(new int[] {1, 2, 3, 4, 4, 5, 5, 100});
        ListNode.printList(head);
        ListNode reverse = reverseList_Recursive(head);
        ListNode.printList(reverse);
    }
}