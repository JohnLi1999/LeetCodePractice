package hard._0023_Merge_k_Sorted_Lists;

import utils.list_node.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*  https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O( n*k*log(n*k) )
        Where n is the average length of the all lists, k is the number of all lists.
        In total, we need to add and remove (n * k) numbers in and out of the priority queue, and each
        operation takes log(n * k) time. So the overall time complexity is O( n*k*log(n*k) )
    Space complexity: O (n * k)
        The priority queue need to store all numbers from the all the lists, which is n * k
 */
public class Solution_My_Way_Slow_Priority_Queue {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            while (list != null) {
                pq.add(new ListNode(list.val));
                list = list.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;

        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
        }

        return result.next;
    }
}
