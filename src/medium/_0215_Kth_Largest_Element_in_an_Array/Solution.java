package medium._0215_Kth_Largest_Element_in_an_Array;

import java.util.*;

public class Solution {
    /*  https://leetcode.com/problems/kth-largest-element-in-an-array/
        Time complexity:
            O(n) in the average case
            O(n^2) in the worst case
        Space complexity: O(1)
     */
    /** Sample Solution_PureBacktracking. Need to review in the future. Check notes folder for more details */
    public static int findKthLargest_QuickSelect(int[] nums, int k) {
        int size = nums.length;
        // kth largest is (N - k)th smallest
        return quickSelect(nums, 0, size - 1, size - k);
    }

    public static int quickSelect(int[] nums, int left, int right, int k_smallest) {
        /* Returns the k-th smallest element of list within left..right. */

        // If the list contains only one element, return that element
        if (left == right) {
            return nums[left];
        }

        // Select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(nums, left, right, pivot_index);

        // The pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index) {
            return nums[k_smallest];
        } else if (k_smallest < pivot_index) {
            // go left side
            return quickSelect(nums, left, pivot_index - 1, k_smallest);
        } else {
            // go right side
            return quickSelect(nums, pivot_index + 1, right, k_smallest);
        }
    }

    public static int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];

        // 1. move pivot to end
        swap(nums, pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(nums, store_index, right);

        return store_index;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    /*  Time Complexity: O(n*log(n))
        Space Complexity: O(k)
            We need to store at most k elements in the heap
     */
    public static int findKthLargest_Heap(int[] nums, int k) {
        // Initialize a min-heap (PriorityQueue is a min-heap by default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            /*  Remove the smallest value and
                keep the size of heap to be k
             */
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top of the heap is the kth largest element in the array
        return minHeap.peek();
    }

    /*  Time Complexity: O(n*log(n))
        Space Complexity: O(1)
     */
    public static int findKthLargest_Sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
