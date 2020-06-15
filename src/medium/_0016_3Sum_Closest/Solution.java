package medium._0016_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    /*  https://leetcode.com/problems/3sum-closest/
        Time Complexity: O(n^2)
            We have outer and inner loops, each going through n elements.
            Sorting the array takes O(n*log(n)), so overall complexity is O(n*log(n) + n^2).
            This is asymptotically equivalent to O(n^2).
        Space Complexity: from O(log(n)) to O(n)
            Depending on the implementation of the sorting algorithm.
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // Initialize the minimum difference with a very large number
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            // Use Two Pointers Strategy
            int low = i + 1, high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                // Case for sum is equals to the target
                if (sum == target) {
                    return target;
                }

                // Update minimum difference
                if (Math.abs(sum - target) < Math.abs(diff)) {
                    diff = sum - target;
                }

                if (sum > target) { // Case for sum is larger than the target
                    high--;
                } else if (sum < target) { // Case for sum is smaller than the target
                    low++;
                }
            }
        }

        return target + diff;
    }
}
