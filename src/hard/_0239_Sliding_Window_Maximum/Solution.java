package hard._0239_Sliding_Window_Maximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /*  Time complexity: O(N)
            Since each element is processed exactly twice - it's index added and then removed from the deque.
        Space complexity: O(N)
            Since O(N−k+1) is used for an output array and O(k) for a deque.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        // If nums contains no element or k is 0, return an empty array
        if (len * k == 0) return new int[0];
        // If k is 1, return the original array
        if (k == 1) return nums;

        // Use a deque that contains indices to save the index of temporal largest value at the head position
        Deque<Integer> window = new LinkedList<>();
        // Initialized the result array with (len - k + 1) length
        int[] result = new int[len - k + 1];

        // Iterate all elements in the array
        for (int i = 0; i < len; i++) {
            // Remove elements that are not belong to the current window from the tail of the deque
            if (i >= k && window.peekFirst() < (i - k + 1)) {
                window.pollFirst();
            }

            /*  Loop through the deque from the tail to the head
                When the current value is larger than the tail value in the deque, remove it from the deque
             */
            while (!window.isEmpty() && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }

            // Add the current into the tail of deque
            window.offerLast(i);

            // If i >= (k - 1), save the largest value (head of the deque) into the result array
            if (i >= (k - 1)) {
                result[i - k + 1] = nums[window.peekFirst()];
            }
        }

        return result;
    }
}
