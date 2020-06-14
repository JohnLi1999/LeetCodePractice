package medium._0015_3Sum;

import java.util.*;

public class Solution {
    /*  https://leetcode.com/problems/3sum/
        Time Complexity: O(n^2)
            The time complexity of twoSum function is O(n), and we call it n times.
            Sorting the array takes O(n*log(n)), so overall complexity is O(n*log(n) + n^2).
            This is asymptotically equivalent to O(n^2).
        Space Complexity: from O(log(n)) to O(n)
            Depending on the implementation of the sorting algorithm.
            For the purpose of complexity analysis, we ignore the memory required for the output.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i == 0 || nums[i] != nums[i - 1]) {
                // Use Two Pointers Strategy
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    public static void twoSum(int nums[], int i, List<List<Integer>> result) {
        int low = i + 1, high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];

            if (sum > 0) {
                high--;
            } else if (sum < 0) {
                low++;
            } else {
                result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));

                // Skip duplicates
                while (nums[low] == nums[low - 1] && low < high) low++;
                while (nums[high] == nums[high + 1] && low < high) high--;
            }
        }
    }
}
