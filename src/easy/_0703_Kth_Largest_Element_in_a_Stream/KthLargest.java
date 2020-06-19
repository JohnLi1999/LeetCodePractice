package easy._0703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

public class KthLargest {
    /* https://leetcode.com/problems/kth-largest-element-in-a-stream/ */

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            minHeap.add(num);
        }
    }

    /*  Time Complexity: O(n*log(n))
        Space Complexity: O(k)
            We need to store at most k elements in the heap
     */
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
