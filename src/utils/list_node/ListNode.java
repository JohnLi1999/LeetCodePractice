package utils.list_node;

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
    public ListNode arrayToListNodes(int[] arr) {
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
}
