package easy._0206_Reverse_Linked_List;

import utils.list_node.ListNode;

public class Solution {
    /*  https://leetcode.com/problems/reverse-linked-list/
        Time complexity : O(n)
            Assume that n is the list's length, the time complexity is O(n).
        Space complexity : O(1)
     */
    public static ListNode reverseList_Iterative(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    /*
        Time complexity : O(n)
            Assume that n is the list's length, the time complexity is O(n).
        Space complexity : O(n)
            The extra space comes from implicit stack space due to recursion.
            The recursion could go up to n levels deep.
     */
    public static ListNode reverseList_Recursive(ListNode head) {
        // Find the last node in the list
        if (head == null || head.next == null) {
            return head;
        }

        // Set the last node in the list as the head of the reverse list, a
        ListNode reverseHead = reverseList_Recursive(head.next);

        /*  Reverse the direction between two adjacent nodes
            For example:
                initial stage :
                    1 -> 2 -> 3 -> 4 (head) -> 5 (reverse_head) -> null
                after "head.next.next = head;" :
                    1 -> 2 -> 3 -> 4 (head) <-> 5 (reverse_head)
                after "head.next = null;" :
                    1 -> 2 -> 3 -> 4 (head) <- 5 (reverse_head)
                                   |_> null
                Now the complete reverse_head is
                    5 -> 4 -> null
         */
        head.next.next = head;
        head.next = null;

        // We will always return the reverse head
        return reverseHead;
    }
}
