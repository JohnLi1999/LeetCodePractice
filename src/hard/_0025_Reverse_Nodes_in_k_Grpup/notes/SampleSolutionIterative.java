package hard._0025_Reverse_Nodes_in_k_Grpup.notes;

import utils.list_node.ListNode;

public class SampleSolutionIterative {
    /** Sample Solution_PureBacktracking. Need to review in the future. */
    /*  Time Complexity: O(N)
            since we process each node exactly twice.
            Once when we are counting the number of nodes in each recursive call,
            and then once when we are actually reversing the sub-list.
        Space Complexity: O(1)
     */
    public ListNode reverseLinkedList(ListNode head, int k) {

        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains
        // at least k nodes.
        ListNode new_head = null;
        ListNode ptr = head;

        while (k > 0) {

            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;

            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;

            // Move on to the next node
            ptr = next_node;

            // Decrement the count of nodes to be reversed by 1
            k--;
        }

        // Return the head of the reversed list
        return new_head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        ListNode ktail = null;

        // Head of the final, modified linked list
        ListNode new_head = null;

        // Keep going until there are nodes in the list
        while (ptr != null) {

            int count = 0;

            // Start counting nodes from the head
            ptr = head;

            // Find the head of the next k nodes
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }

            // If we counted k nodes, reverse them
            if (count == k) {

                // Reverse k nodes and get the new head
                ListNode revHead = this.reverseLinkedList(head, k);

                // new_head is the head of the final linked list
                if (new_head == null)
                    new_head = revHead;

                // ktail is the tail of the previous block of
                // reversed k nodes
                if (ktail != null)
                    ktail.next = revHead;

                ktail = head;
                head = ptr;
            }
        }

        // attach the final, possibly un-reversed portion
        if (ktail != null)
            ktail.next = head;

        return new_head == null ? head : new_head;
    }
}
