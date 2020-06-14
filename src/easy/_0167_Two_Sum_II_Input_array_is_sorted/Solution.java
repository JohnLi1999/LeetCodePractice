package easy._0167_Two_Sum_II_Input_array_is_sorted;

public class Solution {
    /*  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        Time complexity: O(n)
            Each of the nn elements is visited at most once, thus the time complexity is O(n).
        Space complexity: O(1)
            We only use two indexes, the space complexity is O(1).
     */
    public static int[] twoSum(int[] numbers, int target) {
        // Use Two Pointers strategy
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];

            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                return new int[] {low + 1, high + 1};
            }
        }

        return null;
    }
}
