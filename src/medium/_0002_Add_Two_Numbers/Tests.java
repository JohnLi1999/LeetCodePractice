package medium._0002_Add_Two_Numbers;

import org.junit.jupiter.api.Test;
import medium._0002_Add_Two_Numbers.Solution.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        printNode(arrayToListNode(new int[] {1, 2, 3}));
    }

    // Helper functions
    ListNode arrayToListNode(int[] arr) {
        ListNode listNode = new ListNode(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {
            listNode.next = new ListNode(arr[i]);
        }

        return listNode;
    }

    void printNode(Solution.ListNode listNode) {
        if (listNode.next == null) {
            System.out.println(listNode.val);
        }
        System.out.println(listNode.val + " -> ");
        printNode(listNode.next);
    }
}