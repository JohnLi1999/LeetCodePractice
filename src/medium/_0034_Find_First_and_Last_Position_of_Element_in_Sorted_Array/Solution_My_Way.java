package medium._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

/*  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    Time complexity: O(logN)
    Space complexity: O(1)
 */
public class Solution_My_Way {
    public int[] searchRange(int[] nums, int target) {
        int index = -1, start = -1, end = -1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (target == nums[middle]) {
                index = middle;
                break;
            }

            if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        if (index != -1) {
            start = index;
            while (start - 1 >= 0 && nums[start - 1] == target) {
                start--;
            }
            end = index;
            while (end + 1 < nums.length && nums[end + 1] == target) {
                end++;
            }
        }

        return new int[] {start, end};
    }
}
