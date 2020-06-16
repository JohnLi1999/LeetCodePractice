package easy._0141_Linked_List_Cycle;

import utils.list_node.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*  https://leetcode.com/problems/linked-list-cycle/
        Time complexity : O(n)
            Let us denote n as the total number of nodes in the linked list.
            To analyze its time complexity, we consider the following two cases separately.
                1. List has no cycle:
                    The fast pointer reaches the end first and the run time depends on the list's length,
                    which is O(n).
                2. List has a cycle:
                    We break down the movement of the slow pointer into two steps,
                    the non-cyclic part and the cyclic part:
                        2.1. The slow pointer takes "non-cyclic length" steps to enter the cycle.
                             At this point, the fast pointer has already reached the cycle.
                             "Number of iterations" == "non-cyclic length" == "N"
                        2.2. Both pointers are now in the cycle.
                             Consider two runners running in a cycle - the fast runner moves 2 steps while
                             the slow runner moves 1 steps at a time. Since the speed difference is 1,
                             it takes (distance between the 2 runners / difference of speed) loops
                             for the fast runner to catch up with the slow runner.
                             As the distance is at most "cyclic length K" and the speed difference is 1,
                             we conclude that "Number of iterations" == almost "cyclic length K"
            Therefore, the worst case time complexity is O(N+K), which is O(n).
        Space complexity : O(1)
            We only use two nodes (slow and fast) so the space complexity is O(1).
     */
    public static boolean hasCycle_TwoPointer(ListNode head) {
        if (head == null || head.next == null) return false;

        // Initialize a fast and a slow pointer where fast's speed is two time than slow's speed
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            // If the pointer reaches null, it indicates the list has a end and means there is not a cycle in the list
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // If fast and slow pointer meet, then there is a cycle int the list
        return true;
    }

    /*
        Time complexity : O(n)
            We visit each of the n elements in the list at most once.
            Adding a node to the hash table costs only O(1) time.
        Space complexity: O(n)
            The space depends on the number of elements added to the hash table,
            which contains at most n elements.
     */
    public static boolean hasCycle_HashTable(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }

            seen.add(head);
            head = head.next;
        }

        return false;
    }
}
