package medium._0002_Add_Two_Numbers;

import utils.list_node.ListNode;

public class Solution {
    /*  https://leetcode.com/problems/add-two-numbers/
        Time Complexity: O(max(m, n))
            Assume that m and n represents the length of l1 and l2 respectively,
            the algorithm above iterates at most max(m, n) times.
        Space Complexity: O(max(m,n))
            The length of the new list is at most max(m,n)+1.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head for the returned ListNode
        ListNode dummyHead = new ListNode(0);

        // Helper pointer to point the current position of list 1, list 2, and the result list
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode currResult = dummyHead;

        // Helper variable for possible carryover
        int carry = 0;

        /* Iterate all nodes in the two lists */
        while (currL1 != null || currL2 != null) {
            /* If the current node in the list is not null, obtain the current value.
               Otherwise set it to 0  */
            int val1 = (currL1 != null) ? currL1.val : 0;
            int val2 = (currL2 != null) ? currL2.val : 0;

            int sum = val1 + val2 + carry;
            // If the sum is larger than 10, carry will be 1. Otherwise carry is 0
            carry = sum / 10;

            // Always add the last digit in the sum into the result list
            currResult.next = new ListNode(sum % 10);
            currResult = currResult.next;

            // Null check for both lists
            if (currL1 != null)
                currL1 = currL1.next;
            if (currL2 != null)
                currL2 = currL2.next;
        }

        // Address the case that there is a carryover after two lists are finished
        if (carry > 0) {
            currResult.next = new ListNode(carry);
        }

        // Ignore the dummy head and returned the rest of the nodes in the list
        return dummyHead.next;
    }
}
