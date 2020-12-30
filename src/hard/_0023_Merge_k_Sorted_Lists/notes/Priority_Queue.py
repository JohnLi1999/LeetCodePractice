from Queue import PriorityQueue

'''
https://leetcode.com/problems/merge-k-sorted-lists/
    Time complexity: O(N*log(k) where k is the number of linked lists.
        The comparison cost will be reduced to O(log(k)) for every pop and insertion to priority queue.
        But finding the node with the smallest value just costs O(1) time.
        There are N nodes in the final linked list.
    Space complexity :
        O(n) Creating a new linked list costs O(n) space.
        O(k) The code above present applies in-place method which cost O(1) space.
        And the priority queue (often implemented with heaps) costs O(k) space
        (it's far less than N in most situations).
'''
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = point = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, l))
        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next