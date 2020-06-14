package easy._0167_Two_Sum_II_Input_array_is_sorted;

public class Solution {
    /*  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // Use two-point strategy
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }

        return null;
    }
}
