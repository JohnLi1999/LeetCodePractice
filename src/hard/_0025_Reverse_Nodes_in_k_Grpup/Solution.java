package hard._0025_Reverse_Nodes_in_k_Grpup;

import utils.list_node.ListNode;

public class Solution {
    /*  https://leetcode.com/problems/reverse-nodes-in-k-group/
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Return the original list if k is 1
        if (k == 1) {
            return head;
        }

        // Initialize the result with a dummy head
        ListNode result = new ListNode(-1, head);
        // Ini a current node and a previous node
        ListNode curr = head, prev = result;
        // Initialize a counter to 1, and it count for the k value
        int count = 1;

        // Keep check until the end of the list
        while (curr != null) {
            // Mark the start position, which is the current node
            ListNode start = curr;

            // Check whether the rest of the list have k nodes
            while (curr != null && count != k) {
                curr = curr.next;
                // If we have reached the end of the list, we do not increase the counter
                if (curr != null) {
                    count++;
                }
            }

            // If we find k nodes, then we reverse then
            if (count == k) {
                // Reverse the k nodes between prev and curr.next (exclusive)
                reverse(prev, curr.next);
                // Now the start node is the end of the reversed k nodes, and we set it to the new prev
                prev = start;
                // We update the current node to the next unchecked node
                curr = start.next;
                // And reset the counter back to 1
                count = 1;
            }
        }

        // Return the result without the dummy head
        return result.next;
    }

    /**
     * Reverse all nodes between prev and nextStart (exclusive)
     * If there is no node or only one node between prev and nextStart,
     * We will keep everything the same
     *
     * @param prev      the node to begin with
     * @param nextStart the node indicates the last position
     */
    public static void reverse(ListNode prev, ListNode nextStart) {
        ListNode curr = prev.next, next = nextStart;

        while (curr != nextStart) {
            prev.next = curr;

            ListNode temp = curr.next;
            curr.next = next;
            next = curr;
            curr = temp;
        }
    }
}
