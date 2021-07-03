package hard._0025_Reverse_Nodes_in_k_Grpup.round_2;

import utils.list_node.ListNode;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.arrayToListNodes(new int[] {1,2,3,4,5});
        ListNode.printList(s.reverseKGroup(head, 2));
    }

    /*  Safety check + reverse a group of k nodes
        Time complexity: O(2n)
            Safety check needs time of n, and reverse needs time of n
        Space complexity: O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        ListNode tail = result;

        ListNode curHead = head;
        ListNode nextHead = null;

        while (true) {
            // 1. Check if the kth node exists
            ListNode current = curHead;
            int i;
            for (i = 0; i < k; i++) {
                if (current != null) {
                    current = current.next;
                    if (i == k - 1) {
                        nextHead = current;
                    }
                    continue;
                }
                break;
            }

            if (i == k) {
                tail.next = reverse(curHead, nextHead, k);
                tail = curHead;
                curHead = nextHead;
            } else {
                tail.next = curHead;
                break;
            }
        }

        return result.next;
    }

    /*  Example: k = 3
        tail  ->  1  ->  2  ->  3  ->  4  ->  5  ->  6  -> ...
          ^       ^             ^      ^
          |       |             |      |
      result's  curHead     returned nextHead
        tail
     */
    public ListNode reverse(ListNode curHead, ListNode nextHead, int k) {
        int count = k;

        ListNode prev = nextHead;
        ListNode cur = curHead;
        ListNode next;

        while (count > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }

        return prev;
    }
}
