package hard._0023_Merge_k_Sorted_Lists;

import utils.list_node.ListNode;

/*  https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O( n*k*log(k) )
    Space complexity: O(1)
        No extra space is used
 */
public class Solution_Divide_and_Conquer_Recursive {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }

        int middle = low + (high - low) / 2;
        return mergeTwoLists(mergeKLists(lists, low, middle), mergeKLists(lists, middle + 1, high));
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        }

        b.next = mergeTwoLists(a, b.next);
        return b;
    }
}
