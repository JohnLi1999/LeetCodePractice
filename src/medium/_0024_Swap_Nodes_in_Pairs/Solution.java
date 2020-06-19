package medium._0024_Swap_Nodes_in_Pairs;

import utils.list_node.ListNode;

public class Solution {
    /*  https://leetcode.com/problems/swap-nodes-in-pairs/
        Time Complexity : O(N)
            Where N is the size of the linked list.
        Space Complexity : O(1)
     */
    public static ListNode swapPairs_Iterative(ListNode head) {
        // Initialize the result with a dummy node at the beginning
        ListNode result = new ListNode(-1, head);

        // Initialize prev and curr nodes
        ListNode prev = result;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // Declare a pointer that points next pair of nodes
            ListNode next = curr.next.next;

            // Swap the current pair of nodes
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = next;

            // Update prev and curr nodes
            prev = curr;
            curr = next;
        }

        // Return the result without the dummy node at the beginning
        return result.next;
    }

    /*  Time Complexity: O(N)
            Where N is the size of the linked list.
        Space Complexity: O(N)
            Stack space utilized for recursion.
     */
    public static ListNode swapPairs_Recursive(ListNode head) {
        /*  Return the head when there is no more node in the list
            or there is only one node left which cannot make a pair */
        if (head == null || head.next == null) {
            return head;
        }

        // Get the two nodes in current pair
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        /*  Swap the nodes in current pair
            The next of the firstNode is the Remaining Swapped List */
        firstNode.next = swapPairs_Recursive(head.next.next);
        secondNode.next = firstNode;

        // Return the second node in the pair (second node is the head no)
        return secondNode;
    }
}
