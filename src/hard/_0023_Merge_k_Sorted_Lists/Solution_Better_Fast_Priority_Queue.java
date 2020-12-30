package hard._0023_Merge_k_Sorted_Lists;

import utils.list_node.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*  https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O( n*k*log(k) )
        Where n is the average length of the all lists, k is the number of all lists.
        In this way, we only consider the first element in each list. So the size of the priority queue is
        k, which is the number of all lists. Thus, we need to add and remove (n * k) values
        in and out of the priority queue, but each operation only takes log(k) time.
        Therefore the overall time complexity is O( n*k*log(k) )
    Space complexity: O(n * k)
        We store only the first node of all lists in priority queue (O(k)), but create the result
        list takes O(n * k) time
 */
public class Solution_Better_Fast_Priority_Queue {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int k = lists.length;

        /* Declare a fake head and a current node to track the tail of the list */
        ListNode result = new ListNode(-1);
        ListNode current = result;

        /*  The size of the priority queue can just be the number of total lists
            And we store all the first node of the lists into the priority queue  */
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            /* Pull out the smallest element and update the result list */
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            /*  If the list still has elements inside,
                we need to add it back (without the first node) */
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return result.next;
    }
}
