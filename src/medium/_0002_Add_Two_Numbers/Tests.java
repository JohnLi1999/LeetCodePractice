package medium._0002_Add_Two_Numbers;

import org.junit.jupiter.api.Test;
import medium._0002_Add_Two_Numbers.Solution.ListNode;
import static medium._0002_Add_Two_Numbers.Solution.addTwoNumbers;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        printNode(list); // 1 -> 2
    }

    @Test
    void test2() {
        printNode(arrayToListNode(new int[] {3, 4, 2})); // 2 -> 4 -> 3
    }

    @Test
    void test3() {
        ListNode l1 = arrayToListNode(new int[] {3, 4, 2});
        ListNode l2 = arrayToListNode(new int[] {4, 6, 5});
        ListNode expectedResult = arrayToListNode(new int[] {8, 0, 7});
        printNode(l1); // 2 -> 4 -> 3
        printNode(l2); // 5 -> 6 -> 4
        printNode(expectedResult); // 7 -> 0 -> 8
        printNode(addTwoNumbers(l1, l2));  // 7 -> 0 -> 8
    }

    @Test
    void test4() {
        ListNode l1 = arrayToListNode(new int[] {3, 9, 9, 9});
        ListNode l2 = arrayToListNode(new int[] {4, 1, 1, 1});
        ListNode expectedResult = arrayToListNode(new int[] {8, 1, 1, 0});
        printNode(l1); // 9 -> 9 -> 9 -> 3
        printNode(l2); // 1 -> 1 -> 1 -> 4
        printNode(expectedResult); // 0 -> 1 -> 1 -> 8
        printNode(addTwoNumbers(l1, l2));  // 0 -> 1 -> 1 -> 8
    }

    @Test
    void test5() {
        ListNode l1 = arrayToListNode(new int[] {9, 9, 9, 9});
        ListNode l2 = arrayToListNode(new int[] {1, 1});
        ListNode expectedResult = arrayToListNode(new int[] {1, 0, 0, 1, 0});
        printNode(l1); // 9 -> 9 -> 9 -> 9
        printNode(l2); // 1 -> 1
        printNode(expectedResult); // 0 -> 1 -> 0 -> 0 -> 1
        printNode(addTwoNumbers(l1, l2)); // 0 -> 1 -> 0 -> 0 -> 1
    }

    // Helper functions
    ListNode arrayToListNode(int[] arr) {
        ListNode listNode = new ListNode(arr[arr.length - 1]);
        ListNode currentNode = listNode;

        for (int i = arr.length - 2; i >= 0; i--) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        return listNode;
    }

    void printNode(Solution.ListNode listNode) {
        if (listNode.next == null) {
            System.out.println(listNode.val);
            return;
        }
        System.out.print(listNode.val + " -> ");
        printNode(listNode.next);
    }
}