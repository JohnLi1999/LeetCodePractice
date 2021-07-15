package medium._0018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*  https://leetcode.com/problems/4sum/
        Time Complexity: O(n^(k−1)), or O(n^3) for 4Sum
            We have (k - 2) loops, and twoSum is O(n).
            Note that for k > 2, sorting the array does not change the overall time complexity.
            Remove elements from temporal result list takes O(k) time complexity, and we treat k
            as a constant in this problem
        Space Complexity: O(k).
            The temporal result list holds up to k elements
            Note that, for the purpose of complexity analysis, we ignore the memory required for the output.
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Sort the array so that Two Pointers Strategy can be applied
        Arrays.sort(nums);
        // Solution_PureBacktrack List
        List<List<Integer>> result = new ArrayList<>();
        // Helper List that contains temporal results
        List<Integer> tempResult = new ArrayList<>();
        // Generalized Solution_PureBacktracking for k-Sum questions
        kSum(nums, 0, target, 4, tempResult, result); // k = 4 for Four Sum
        return result;
    }

    /**
     * A generalized solution for k-Sum problems.
     * It takes a sorted array (ascending order) and returns a collection of lists
     * which has k numbers whose sum is equal to the target number.
     *
     * @param nums          a sorted array
     * @param startIndex    start index to iterate in the array
     * @param target        the target number
     * @param k             expected numbers to add for a sum
     * @param tempResult    a helper list that hold temporal results
     * @param result        result list
     */
    public static void kSum(int[] nums, int startIndex, int target, int k, List<Integer> tempResult, List<List<Integer>> result) {
        // Return if the array does not the meet the requirement
        if (nums.length < k) return;

        if (k == 2) {
            // Base case: 2-Sum
            twoSum(nums, startIndex, target, tempResult, result);
        } else {
            for (int i = startIndex; i < nums.length - k + 1; i++) {
                /*  If the sum of k smallest values is greater than target, or the sum of k largest values
                    is smaller than target. We don't need to check the rest numbers in the array */
                if (nums[i] * k > target || nums[nums.length - 1] * k < target) break;

                // Skip duplicates
                if (i != startIndex && nums[i] == nums[i - 1]) continue;

                // Add the current value into tempResult before recursion
                tempResult.add(nums[i]);
                // Check (k-1)-Sum recursively
                kSum(nums, i + 1, target - nums[i], k - 1, tempResult, result);
                // Reset tempResult for later answers
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    /**
     * The base case for k-Sum problems.
     * Use two pointers strategy to find two numbers added to the target number,
     * and save them into the result list
     *
     * @param nums          a sorted array
     * @param startIndex    start index to iterate in the array
     * @param target        the target number
     * @param tempResult    a helper list that hold temporal results
     * @param result        result list
     */
    public static void twoSum(int[] nums, int startIndex, int target, List<Integer> tempResult, List<List<Integer>> result) {
        int low = startIndex, high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];

            if (sum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) { // Skip duplicates
                high--;
            } else if (sum < target || (low > startIndex && nums[low] == nums[low - 1])) { // Skip duplicates
                low++;
            } else {
                tempResult.add(nums[low++]);
                tempResult.add(nums[high--]);
                // Add tempResult into the result list
                result.add(new ArrayList<>(tempResult));

                // Reset tempResult for later answers
                tempResult.remove(tempResult.size() - 1);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }
}
