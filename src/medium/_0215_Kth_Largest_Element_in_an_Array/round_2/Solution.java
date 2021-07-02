package medium._0215_Kth_Largest_Element_in_an_Array.round_2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution r = new Solution();

//        int result = r.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 9);
//        int result = r.findKthLargest(new int[] {3,2,1,5,6,4}, 2);
        int result = r.findKthLargest(new int[] {-1,2,0}, 2);

        System.out.println("result: " + result);
    }

    public int findKthLargest(int[] nums, int k) {
        /*  Quick Select
            time complexity: O(n) average, O(n^2) worst
            space complexity: O(1)
         */
//        return quickSelect(nums, 0, nums.length - 1, k);

        /*  Priority Queue
            time complexity: O(n*log(k))
            space complexity: O(k)
         */
        return priorityQueue(nums, k);
    }

    public int priorityQueue(int[] nums, int k) {
        // Better way: using minHeap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();

//        // Use maxHeap
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int num : nums) {
//            maxHeap.add(num);
//        }
//
//        for (int i = 1; i < k; i++) {
//            maxHeap.poll();
//        }
//
//        return maxHeap.poll();
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        // 1. select the last element as the pivot
        int pivot = nums[end];

        // 3. check the index to k,
        // if index < k, repeat with right arr
        // if index > k, repeat with left arr
        int pivotIndex = partition(nums, start, end, pivot);

        if (pivotIndex == k - 1) {
            return nums[pivotIndex];
        } else if (pivotIndex < k - 1) {
            return quickSelect(nums, pivotIndex + 1, end, k);
        } else {
            return quickSelect(nums, start, pivotIndex - 1, k);
        }
    }

    public int partition(int[] nums, int start, int end, int pivot) {
        // A better partition
        // 2. put all numbers smaller than it to left arr, larger than it to right arr
        int i = start;
        int j = end;

        int k = end - 1;
        while (i < j) {
            if (nums[k] < pivot) {
                nums[j] = nums[k];
                j--;
                k--;
            } else {
                swap(nums, k, i);
                i++;
            }
        }

        nums[i] = pivot;
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
