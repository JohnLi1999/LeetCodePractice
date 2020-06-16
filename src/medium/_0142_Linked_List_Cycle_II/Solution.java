package medium._0142_Linked_List_Cycle_II;

import utils.list_node.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*  https://leetcode.com/problems/linked-list-cycle-ii/
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static ListNode detectCycle_TwoPointers(ListNode head) {
        if (head == null || head.next == null) return null;

        /*  Initialize a fast and a slow pointer at the beginning of the list
            where fast's speed is two time than slow's speed
         */
        ListNode slow = head;
        ListNode fast = head;

        do {
            // If the pointer reaches null, it indicates the list has a end and means there is not a cycle in the list
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != fast); // If fast and slow pointer meet, then there is a cycle int the list

        /*  When found the position where slow and faster pointers meet,
            reset slow pointer to the beginning of the list, and
            let fast pointer stays at intersection

            For the reason to do this, please check "142. Linked List Cycle II.pdf" in "notes" folder
         */
        slow = head;

        // When fast and slow pointers meet again, the position is at the entrance of the cycle
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    /*
        Time complexity : O(n)
            For both cyclic and acyclic inputs, the algorithm must visit each node exactly once.
            This is transparently obvious for acyclic lists because the nth node points to null,
            causing the loop to terminate.
            For cyclic lists, the if condition will cause the function to return after visiting the nth node,
            as it points to some node that is already in visited.
            In both cases, the number of nodes visited is exactly n,
            so the runtime is linear in the number of nodes.
        Space complexity : O(n)
            For both cyclic and acyclic inputs, we will need to insert each node into the Set once.
            The only difference between the two cases is whether we discover that the "last" node
            points to null or a previously-visited node.
            Therefore, because the Set will contain n distinct nodes,
            the memory footprint is linear in the number of nodes.
     */
    public static ListNode detectCycle_HashTable(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (seen.contains(curr)) {
                return curr;
            }

            seen.add(curr);
            curr = curr.next;
        }

        return null;
    }
}
