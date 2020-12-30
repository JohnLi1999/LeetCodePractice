'''
https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O(N*log(N)), where N is the total number of nodes.
        Collecting all the values costs O(N) time.
        A stable sorting algorithm costs O(N*logN) time.
        Iterating for creating the linked list costs O(N) time.
    Space complexity : O(N)
        Sorting cost O(N) space (depends on the algorithm you choose.
        Creating a new linked list costs O(N) space.
'''
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        self.nodes = []
        head = point = ListNode(0)
        for l in lists:
            while l:
                self.nodes.append(l.val)
                l = l.next
        for x in sorted(self.nodes):
            point.next = ListNode(x)
            point = point.next
        return head.next