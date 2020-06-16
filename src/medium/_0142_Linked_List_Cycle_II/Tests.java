package medium._0142_Linked_List_Cycle_II;

import org.junit.jupiter.api.Test;
import utils.list_node.ListNode;

import static medium._0142_Linked_List_Cycle_II.Solution.detectCycle_TwoPointers;
import static medium._0142_Linked_List_Cycle_II.Solution.detectCycle_HashTable;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
    ListNode zero = null;
    ListNode one = null;
    ListNode two = null;
    ListNode three = null;
    ListNode four = null;

    void resetNodesZeroToFour() {
        zero = new ListNode(0);
        one = new ListNode(1);
        two = new ListNode(2);
        three = new ListNode(3);
        four = new ListNode(4);
    }

    @Test
    void test1() {
        resetNodesZeroToFour();
        ListNode head = three;
        three.next = two;
        two.next = zero;
        zero.next = four;
        four.next = two;
        ListNode expectedResult = two;
        assertEquals(expectedResult, detectCycle_TwoPointers(head));
    }

    @Test
    void test2() {
        resetNodesZeroToFour();
        ListNode head = one;
        one.next = two;
        two.next = one;
        ListNode expectedResult = one;
        assertEquals(expectedResult, detectCycle_TwoPointers(head));
    }

    @Test
    void test3() {
        resetNodesZeroToFour();
        ListNode head = one;
        assertEquals(null, detectCycle_TwoPointers(head));
    }

    @Test
    void test4() {
        resetNodesZeroToFour();
        ListNode head = three;
        three.next = two;
        two.next = zero;
        zero.next = four;
        four.next = two;
        ListNode expectedResult = two;
        assertEquals(expectedResult, detectCycle_HashTable(head));
    }

    @Test
    void test5() {
        resetNodesZeroToFour();
        ListNode head = one;
        one.next = two;
        two.next = one;
        ListNode expectedResult = one;
        assertEquals(expectedResult, detectCycle_HashTable(head));
    }

    @Test
    void test6() {
        resetNodesZeroToFour();
        ListNode head = one;
        assertEquals(null, detectCycle_HashTable(head));
    }
}