package hard._0023_Merge_k_Sorted_Lists;

import utils.list_node.ListNode;

/*  https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O( n*k*log(k) )
    Space complexity: O(1)
        No extra space is used
 */
public class Solution_Divide_and_Conquer_Iterative {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;

        /*  e.g.
            indices: [0, 1, 2, 3, 4] --- len: 5
            round 1: [0,  , 2,  , 4] --- size: 1 (index 1 and 3 are merged)
            round 2: [0,  ,  ,  , 4] --- size: 2 (index 2 are merged)
            round 3: [0,  ,  ,  ,  ] --- size: 4 (index 4 are merged)
         */

        int size = 1;
        while (size < len) {
            for (int i = 0; i < len - size; i += 2 * size) {
                lists[i] = mergeTwoLists(lists[i], lists[i + size]);
            }
            size *= 2;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode result = new ListNode(-1);
        ListNode current = result;

        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }

            current = current.next;
        }

        if (a == null) {
            current.next = b;
        }

        if (b == null) {
            current.next = a;
        }

        return result.next;
    }
}
