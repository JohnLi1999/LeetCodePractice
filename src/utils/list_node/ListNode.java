package utils.list_node;

import java.util.Objects;

/** Definition for singly-linked list. */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Helper functions
    public static ListNode arrayToListNodes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode listNode = new ListNode(arr[0]);
        ListNode currentNode = listNode;

        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        return listNode;
    }

    public static ListNode arrayToListNodesReverse(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode listNode = new ListNode(arr[arr.length - 1]);
        ListNode currentNode = listNode;

        for (int i = arr.length - 2; i >= 0; i--) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        return listNode;
    }

    public static void printList(ListNode listNode) {
        if (listNode.next == null) {
            System.out.println(listNode.val);
            return;
        }
        System.out.print(listNode.val + " -> ");
        printList(listNode.next);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
